package com.cowin.utils;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cowin.exceptions.MemberNotFoundException;
import com.cowin.model.CurrentMemberSession;
import com.cowin.model.Member;
import com.cowin.repository.MemberDao;
import com.cowin.repository.SessionRepo;

@Component
public class CurrentLogInMemberImpl implements CurrentLogInMember{
	
	@Autowired
	private MemberDao memberDAO;
	
	@Autowired
	private SessionRepo sessionREPO;
//	
//	@Autowired
//	private CurrentMemberSession curSes;
//	
	

	@Override
	public CurrentMemberSession getCurrentMemberSession(String key) {
		Optional<CurrentMemberSession> opt = sessionREPO.findBySessionKey(key);
		
		if(!opt.isPresent()) throw new MemberNotFoundException("Member is currently not logged in..");
		
		return opt.get();
	}

	@Override
	public Integer getCurrentMemberSessionId(String key) {
		Optional<CurrentMemberSession> opt = sessionREPO.findBySessionKey(key);
		
		if(!opt.isPresent()) throw new MemberNotFoundException("Member is currently not logged in..");
		
		return opt.get().getCurMid();
	}

	@Override
	public Member getCurrentMemberBySessionKey(String key) {
		
		Optional<CurrentMemberSession> opt = sessionREPO.findBySessionKey(key);
		
		if(!opt.isPresent()) throw new MemberNotFoundException("Member is currently not logged in..");
		
		return memberDAO.getReferenceById(opt.get().getMemberId());

	}

	@Override
	public Member getCurrentMemberByMobileNo(String mobileNo) {
		
		System.out.println(mobileNo);

		Optional<CurrentMemberSession> opt = sessionREPO.findByMobileNo(mobileNo);
		
		System.out.println(opt.get());
		
		if(!opt.isPresent()) throw new MemberNotFoundException("Member is currently not logged in..");
		
		return memberDAO.getReferenceById(opt.get().getMemberId());

	}

}
