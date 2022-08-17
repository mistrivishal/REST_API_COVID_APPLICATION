package com.cowin.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cowin.exceptions.MemberAlreadyExistException;
import com.cowin.exceptions.MemberNotFoundException;
import com.cowin.exceptions.UnAuthorizedPerson;
import com.cowin.exceptions.VaccineCenterNotFound;
import com.cowin.model.CurrentMemberSession;
import com.cowin.model.Member;
import com.cowin.model.MemberDTO;
import com.cowin.model.VaccineCenter;
import com.cowin.model.VaccineCenterDTO;
import com.cowin.repository.MemberDao;
import com.cowin.repository.SessionRepo;
import com.cowin.repository.VaccineCenterDao;
import com.cowin.utils.CurrentLogInMember;

import net.bytebuddy.utility.RandomString;

@Service
public class MemberServiceImpl implements MemberSerive {

	@Autowired
	private MemberDao memDao;

	@Autowired
	private MemberDao memberDao;

	@Autowired
	private SessionRepo sessionRepo;

	@Autowired
	private CurrentLogInMember currentLogInMember;

	@Autowired
	private VaccineCenterDao vaccinecenterdao;

	@Override
	public String logIntoAccount(MemberDTO memberDto) {

		List<Member> memList = memberDao.findByMobileno(memberDto.getMobileno());

		if (memList.isEmpty()) {
			throw new MemberNotFoundException("Please Enter Valid Mobile Number");
		}
		Member newMember = memList.get(0);
		
		if(! newMember.getPassWord().equals(memberDto.getPassWord())) throw new UnAuthorizedPerson("Please Enter correct Password");
		
		Integer memberId = newMember.getMemberId();
		Optional<CurrentMemberSession> currentUserOptional = sessionRepo.findByMemberId(memberId);

		if (currentUserOptional.isPresent()) {
			throw new MemberAlreadyExistException("User already logged in with this number");
		}

		String key = RandomString.make(6);

		CurrentMemberSession currentMemberSession = new CurrentMemberSession(newMember.getMemberId(),
				newMember.getMobileno(), key, LocalDateTime.now());

		sessionRepo.save(currentMemberSession);

		return currentMemberSession.toString();

	}

	@Override
	public String logOutFromAccount(MemberDTO memberDto) {

		Optional<CurrentMemberSession> currentMemberOptional = sessionRepo.findByMobileNo(memberDto.getMobileno());

		if (!currentMemberOptional.isPresent()) {
			throw new MemberNotFoundException("User has to login first");
		}

		CurrentMemberSession currentMemberSession = currentLogInMember.getCurrentMemberSession(currentMemberOptional.get().getSessionKey());

		sessionRepo.delete(currentMemberSession);

		return "Logged Out Successfully";
	}

	@Override
	@Transactional
	public Member saveMember(Member member) throws MemberAlreadyExistException {

		List<Member> memList = memDao.findByMobileno(member.getMobileno());

		if (memList.size() <= 5) {
			for (Member mem : memList) {
				String e_adharNo = mem.getAdharcard().getAdharNo();

				String i_adharNo = member.getAdharcard().getAdharNo();

				String msg = "Member Already exists with ";

				if (e_adharNo.equals(i_adharNo))
					throw new MemberAlreadyExistException(msg + "this Adharcard : " + mem.getAdharcard().getAdharNo());

				memList.add(member);
				return memDao.save(member);
			}
		} else if (memList.size() > 5)
			throw new MemberAlreadyExistException("Only 5 members can register with same number.");

		return memDao.save(member);
	}

	@Override
	public Member updatemember(Member member) throws MemberNotFoundException, UnAuthorizedPerson {

		List<Member> memList = memDao.findByMobileno(member.getMobileno());

		if (memList.isEmpty())
			throw new MemberNotFoundException("Member does not exists with mobile no: " + member.getMobileno());
		
//		System.out.println();
		
		Member currS  = currentLogInMember.getCurrentMemberByMobileNo(member.getMobileno());
		
		if (currS.getMobileno().equals(member.getMobileno())) {

			for (Member mem : memList) {
				String e_adharNo = mem.getAdharcard().getAdharNo();

				String i_adharNo = member.getAdharcard().getAdharNo();

				if (e_adharNo.equals(i_adharNo)) {
					memList.remove(mem);
					memList.add(member);
					return memDao.save(member);
				}

				else
					throw new MemberAlreadyExistException("please provide valid idcard detals to update");
			}
		}

		throw new UnAuthorizedPerson("Unauthorized person..");

	}

	@Override
	public String deletemember(MemberDTO memberDTO) throws MemberNotFoundException, UnAuthorizedPerson {

		List<Member> memList = memDao.findByMobileno(memberDTO.getMobileno());

		if (memList.isEmpty())
			throw new MemberNotFoundException("Member does not exists with mobile no: " + memberDTO.getMobileno());
		
		Optional<CurrentMemberSession> curSes =  sessionRepo.findByMobileNo(memberDTO.getMobileno());
			

		if (memberDTO.getMobileno().equals(curSes.get().getMobileNo())) {

			for (Member mem : memList) {
				String e_adharNo = mem.getAdharcard().getAdharNo();

				String i_adharNo = memberDTO.getAdharNo();

				if (e_adharNo.equals(i_adharNo)) {
					memList.remove(mem);
					memDao.delete(mem);
					return "Member deleted having Adhar number: " + e_adharNo;
				}

				else
					throw new MemberAlreadyExistException("please provide valid idcard detals to update");
			}
		}

		throw new UnAuthorizedPerson("Unauthorized person..");

	}

	@Override
	public List<Member> getMemberByMobileNo(MemberDTO memberDTO)
			throws MemberNotFoundException, UnAuthorizedPerson {

		List<Member> memList = memDao.findByMobileno(memberDTO.getMobileno());

		if (memList.isEmpty())
			throw new MemberNotFoundException("Member does not exists..");
		
		Member newMember = memList.get(0);
		
		if(!newMember.getPassWord().equals(memberDTO.getPassWord())) throw new UnAuthorizedPerson("Please Enter correct Password");
		
		else {
			return memList;
		}
	}

	@Override
	public VaccineCenterDTO getVaccineCenterByCenterName(String vacineCenterName) {

		VaccineCenter vac = vaccinecenterdao.findByVacCenterName(vacineCenterName);
		if (vac == null) {
			throw new VaccineCenterNotFound("No Center Avaliable with this Name " + vacineCenterName);
		}

		VaccineCenterDTO vacDTO = new VaccineCenterDTO();

		vacDTO.setCenter_id(vac.getCenter_id());
		vacDTO.setVacCenterName(vac.getVacCenterName());
		vacDTO.setCenter_address(vac.getCenter_address());

		return vacDTO;
	}

	@Override
	public List<VaccineCenterDTO> getAllVaccineCenter() {

		List<VaccineCenter> VacCenterlist = vaccinecenterdao.findAll();

		if (VacCenterlist == null) {
			throw new VaccineCenterNotFound("No Center Found");
		}

		List<VaccineCenterDTO> vacDTOList = new ArrayList<>();

		for (VaccineCenter vacCenter : VacCenterlist) {

			VaccineCenterDTO vacDTO = new VaccineCenterDTO();

			vacDTO.setCenter_id(vacCenter.getCenter_id());
			vacDTO.setVacCenterName(vacCenter.getVacCenterName());
			vacDTO.setCenter_address(vacCenter.getCenter_address());

			vacDTOList.add(vacDTO);
		}

		return vacDTOList;

	}

}
