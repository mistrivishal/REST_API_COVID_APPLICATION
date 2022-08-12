package com.covidapp.servicelayer;

import java.util.List;

import com.covidapp.exceptionhandler.MemberNotFoundException;
import com.covidapp.module.Member;

public interface MemberService {

	public List<Member> getAllmembers() throws MemberNotFoundException;

	public Member getMemberById(Integer idCardId) throws MemberNotFoundException;

	public Member getMemberByAdharNo(Long adharNo) throws MemberNotFoundException;

	public Member getMemberByPanNo(String panNo) throws MemberNotFoundException;

	public Member addMember(Member member) throws MemberNotFoundException;

	public Member updateMember(Member member) throws MemberNotFoundException;

	public Boolean deleteMember(Member member) throws MemberNotFoundException;

}
