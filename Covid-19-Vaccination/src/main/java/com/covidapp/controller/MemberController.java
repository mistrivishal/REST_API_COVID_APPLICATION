package com.covidapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.covidapp.module.Member;
import com.covidapp.servicelayer.MemberService;

@RestController
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService mService;

	
	@PostMapping("/save")
	public Member saveMember(@Valid @RequestBody Member member) {
		
		return mService.addMember(member);
	}
	
	@GetMapping("/adharNo/{adharNo}")
	public Member getMemberByAdharNum(@Valid @PathVariable Long adharNo) {
		
		return mService.getMemberByAdharNo(adharNo);

	}
	
	@GetMapping("/panNo/{panNo}")
	public Member getMemberByPanNum(@Valid @PathVariable String panNo) {
		
		return mService.getMemberByPanNo(panNo);

	}
	
	@GetMapping("/idCardNo/{idNo}")
	public Member getMemberByIdNum(@Valid @PathVariable Integer idNo) {
		
		return mService.getMemberById(idNo);

	}
	
	@PutMapping("/update")
	public Member updateMember(@Valid @RequestBody Member member) {
		
		return mService.updateMember(member);

	}
	
	@PutMapping("/delete")
	public Boolean deleteMember(@Valid @RequestBody Member member) {
		
		return mService.deleteMember(member);

	}
	
}
