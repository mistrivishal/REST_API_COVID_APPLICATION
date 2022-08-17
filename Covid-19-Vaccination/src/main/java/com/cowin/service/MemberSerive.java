package com.cowin.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cowin.exceptions.MemberAlreadyExistException;
import com.cowin.exceptions.MemberNotFoundException;
import com.cowin.exceptions.UnAuthorizedPerson;
import com.cowin.model.Member;
import com.cowin.model.MemberDTO;
import com.cowin.model.VaccineCenterDTO;

@Component
public interface MemberSerive {
	
	public String logIntoAccount(MemberDTO memberDto) throws RuntimeException;
	
	public String logOutFromAccount(MemberDTO memberDto) throws RuntimeException;

	public Member saveMember(Member member) throws MemberAlreadyExistException;

	public Member updatemember(Member member) throws MemberAlreadyExistException;

	public String deletemember(MemberDTO memberDTO) throws MemberNotFoundException, UnAuthorizedPerson ;

	public List<Member> getMemberByMobileNo(MemberDTO memberDTO) throws MemberNotFoundException, UnAuthorizedPerson;
	
	public VaccineCenterDTO getVaccineCenterByCenterName(String vacineCenterName);

	public List<VaccineCenterDTO> getAllVaccineCenter();

}
