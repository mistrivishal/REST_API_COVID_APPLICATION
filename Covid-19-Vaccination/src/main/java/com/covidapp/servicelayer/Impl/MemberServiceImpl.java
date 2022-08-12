package com.covidapp.servicelayer.Impl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covidapp.exceptionhandler.DuplicateIdException;
import com.covidapp.exceptionhandler.MemberNotFoundException;
import com.covidapp.module.IdCard;
import com.covidapp.module.Member;
import com.covidapp.repository.MembersDao;
import com.covidapp.servicelayer.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MembersDao mDao;

	@Override
	public List<Member> getAllmembers() {

		if (mDao.findAll().size() > 0)
			return mDao.findAll();
		else
			throw new MemberNotFoundException("Member list is empty..");

	}

	@Override
	public Member getMemberById(Integer idCardId) {

		List<Member> members = mDao.findAll();

		for (Member member : members) {

			if (member.getIdcard().getIdCardid() == idCardId) {
				return member;
			}
		}

		throw new MemberNotFoundException("No member found with ID-Card having Id: " + idCardId);

	}

	@Override
	public Member getMemberByAdharNo(Long adharNo) {

		List<Member> members = mDao.findAll();

		for (Member member : members) {

			if (member.getIdcard().getAdhar().getAdharNo() == adharNo) {
				return member;
			}
		}

		throw new MemberNotFoundException("No member found with ID-Card having Id: " + adharNo);
	}

	@Override
	public Member getMemberByPanNo(String panNo) {

		List<Member> members = mDao.findAll();

		for (Member member : members) {

			if (member.getIdcard().getPan().getPanNo() == panNo) {
				return member;
			}
		}

		throw new MemberNotFoundException("No member found with ID-Card having Id: " + panNo);
	}
	
	@Override
	public Member addMember(Member member) {

		List<Member> members = mDao.findAll();

		for (Member mem : members) {
			if (member.getIdcard().getAdhar().getAdharNo() == mem.getIdcard().getAdhar().getAdharNo()) {
				throw new DuplicateIdException("Member Already Exists with adharNo:" + member.getIdcard().getAdhar().getAdharNo());
			}
		}

		return mDao.save(member);
	}

	@Override
	public Member updateMember(Member member) {

		Optional<Member> opts = mDao.findById(member.getMemberId());

		if (opts.isPresent())
			return mDao.save(member);
		else
			throw new MemberNotFoundException("Member does not exists..");
	}

	@Override
	public Boolean deleteMember(Member member) {

		Optional<Member> opts = mDao.findById(member.getMemberId());

		if (opts.isPresent()) {
			mDao.delete(member);
			return true;
		}
		throw new MemberNotFoundException("Member does not exists..");
	}

}
