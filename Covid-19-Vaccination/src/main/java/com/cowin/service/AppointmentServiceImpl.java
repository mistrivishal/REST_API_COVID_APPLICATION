package com.cowin.service;

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
import com.cowin.model.AppoinmetDTO;
import com.cowin.model.Appointment;
import com.cowin.model.CurrentMemberSession;
import com.cowin.model.Member;
import com.cowin.model.Vaccine;
import com.cowin.model.VaccineCenter;
import com.cowin.repository.AppointmentDao;
import com.cowin.repository.MemberDao;
import com.cowin.repository.SessionRepo;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentDao appDao;
	
	@Autowired
	private MemberDao memDao;

	@Autowired
	private SessionRepo sessionRepo;
	
	@Autowired
	private MemberSerive memSer;

	@Autowired
	private VaccineCenterService vacCenterSer;


	@Override
	@Transactional
	public AppoinmetDTO addAppointMentDetails(AppoinmetDTO appDto) {
		
		Optional<CurrentMemberSession> curMem = sessionRepo.findByMobileNo(appDto.getMobileNo());

		if (curMem.isEmpty()) {
			throw new MemberNotFoundException("User has to login first");
		}
		
		if (!(curMem.get().getMobileNo().equals(appDto.getMobileNo()))) {
//			System.out.println(curMem.get().getMobileNo() + "------------" + appDto.getMobileNo() );
			throw new UnAuthorizedPerson("Unthorized entry..");
		}
		
		List<Member> memList = memDao.findByMobileno(appDto.getMobileNo());

		if (memList.isEmpty())
			throw new MemberNotFoundException("Member does not exists please register..");

		Member mem = null;
		for (Member e_mem : memList) {
			String e_adharNo = e_mem.getAdharcard().getAdharNo();

			String i_adharNo = appDto.getAdharNo();

			if (e_adharNo.equals(i_adharNo)) {
				mem = e_mem;
				System.out.println("Its okay ---> memeber exist");
				break;
			}
		}

		if (mem == null)
			throw new MemberNotFoundException("Member is not registered");

		List<Appointment> appointments = mem.getAppointments();

		for (Appointment app : appointments) {
			if (app.getStatus() == true)
				throw new MemberAlreadyExistException("Appoinment already booked");
		}
		
		System.out.println("Its okay ---> memeber exist");

		Appointment appointment = new Appointment();
//		appointment.setMember(mem);

		VaccineCenter i_vacCenter = vacCenterSer.getVaccineCenterByCenterName(appDto.getVacineCenterName());

		if (i_vacCenter == null)
			throw new VaccineCenterNotFound("No center found with name" + appDto.getVacineCenterName());

		List<Vaccine> vaccines = i_vacCenter.getVaccine();

		String i_vaccineName = appDto.getVaccineName();

		System.out.println("Its okay ---> memeber exist");
		
		VaccineCenter b_vacCenter = null;

		for (Vaccine vac : vaccines) {
			if (vac.getVaccineCount() > 0 && i_vaccineName.equalsIgnoreCase(vac.getVaccineName())) {
				vac.setVaccineCount(vac.getVaccineCount() - 1);
				b_vacCenter = i_vacCenter;

				System.out.println("Its okay ---> vaccine exist");
				break;
			}
		}

		if (b_vacCenter == null)
			throw new VaccineCenterNotFound("No center found with vaccine:" + i_vaccineName);		
		
		appointment.setDateOfBooking(appDto.getDateOfBooking());
		appointment.setStatus(true);
		appointment.setVaccineName(i_vaccineName);
		appointment.setVaccineCenterName(b_vacCenter.getVacCenterName());
		b_vacCenter.getAppointments().add(appointment);
		

//		System.out.println("-------------"+mem);
//		
//		System.out.println("-------------"+mem);	
		
		vacCenterSer.updateVaccineCenter(b_vacCenter);
		appDao.saveAndFlush(appointment);
		mem.getAppointments().add(appointment);
		memSer.updatemember(mem);

		return appDto;
	}

	@Override
	@Transactional
	public String deleteAppointMent(AppoinmetDTO appDto) {

		List<Member> memList = memDao.findByMobileno(appDto.getMobileNo());

		if (memList.isEmpty())
			throw new MemberNotFoundException("Member does not exists please register..");

		Member mem = null;
		for (Member e_mem : memList) {
			String e_adharNo = e_mem.getAdharcard().getAdharNo();

			String i_adharNo = appDto.getAdharNo();

			if (e_adharNo.equals(i_adharNo)) {
				mem = e_mem;
				break;
			} else
				throw new MemberNotFoundException("Member is not registered");
		}

		List<Appointment> appointments = mem.getAppointments();

		for (Appointment app : appointments) {
			if (app.getStatus() == true) {
				VaccineCenter vacCenter = vacCenterSer.getVaccineCenterByCenterName(appDto.getVacineCenterName());
				
				if(vacCenter == null) throw new VaccineCenterNotFound("Please provide valid vaccine center name");
				
				List<Vaccine> vaccines = vacCenter.getVaccine();
				
				System.out.println(appDto+"------------------------------------");
				String i_vaccineName = appDto.getVaccineName();
				
				for (Vaccine vac : vaccines) {
					if (i_vaccineName.equalsIgnoreCase(vac.getVaccineName())) {
						vac.setVaccineCount(vac.getVaccineCount() + 1);
						break;
					}
				}
				appointments.remove(app);
				memDao.save(mem);

				return "Appointment deleted successfully";
			}
		}

		return "No appointment booked for this member";
	}

	@Override
	@Transactional
	public List<AppoinmetDTO> getAllAppointmentsOfMember(AppoinmetDTO appDto) {

		List<Member> memList = memDao.findByMobileno(appDto.getMobileNo());

		if (memList.isEmpty())
			throw new MemberNotFoundException("Member does not exists please register..");

		Member mem = null;
		for (Member e_mem : memList) {
			String e_adharNo = e_mem.getAdharcard().getAdharNo();

			String i_adharNo = e_mem.getAdharcard().getAdharNo();

			if (e_adharNo.equals(i_adharNo)) {
				mem = e_mem;
				break;
			} else
				throw new MemberNotFoundException("Member is not registered");
		}

		List<Appointment>memLi = mem.getAppointments();
		
		List<AppoinmetDTO>memDTO = new ArrayList<>();
		
		for(Appointment app: memLi) {
			
			AppoinmetDTO appDT = new AppoinmetDTO();
			
			appDT.setDateOfBooking(app.getDateOfBooking());
			appDT.setVaccineName(app.getVaccineName());
			appDT.setVacineCenterName(app.getVaccineCenterName());
			appDT.setAdharNo(mem.getAdharcard().getAdharNo());	
			appDT.setMobileNo(mem.getMobileno());
			
			memDTO.add(appDT);
			
		}
		
		return memDTO;

	}

}
