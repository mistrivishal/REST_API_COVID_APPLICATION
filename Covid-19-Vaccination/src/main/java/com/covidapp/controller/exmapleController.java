package com.covidapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.covidapp.module.IdCard;
import com.covidapp.servicelayer.IdCardService;
import com.covidapp.servicelayer.MemberService;

@RestController
@RequestMapping("/member")
public class exmapleController {
	
	@Autowired
	private MemberService mService;
	
	@Autowired
	private IdCardService idService;
	
	@PostMapping("/save")
	public IdCard saveIdcard(@Valid @RequestBody IdCard idCard) {
		
		return idService.addIdCard(idCard);
	}
}
