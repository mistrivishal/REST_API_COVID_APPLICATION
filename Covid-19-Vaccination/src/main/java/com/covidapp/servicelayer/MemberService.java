package com.covidapp.servicelayer;

import java.util.List;

import com.covidapp.module.Member;

public interface MemberService {

	public List<Member> getAllmembers();

	public Member getMemberById(Integer idCardId);

	public Member getMemberByAdharNo(Long adharNo);

	public Member addMember(Member member);

	public Member updateMember(Member member);

	public Boolean deleteMember(Member member);
}
