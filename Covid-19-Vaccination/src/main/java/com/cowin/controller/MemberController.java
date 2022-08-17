package com.cowin.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cowin.model.AppoinmetDTO;
import com.cowin.model.Member;
import com.cowin.model.MemberDTO;
import com.cowin.model.VaccineCenterDTO;
import com.cowin.service.AppointmentService;
import com.cowin.service.MemberSerive;

@RestController
@RequestMapping("/user")
public class MemberController {

	@Autowired
	private MemberSerive memberService;

	@Autowired
	private AppointmentService appService;

	@Autowired
	private MemberSerive memService;

	@PostMapping("/register")
	public ResponseEntity<Member> registerMember(@Valid @RequestBody Member memR) {

		Member newMem = memService.saveMember(memR);

		return new ResponseEntity<Member>(newMem, HttpStatus.CREATED);

	}

	@PostMapping("/login")
	public String logInMember(@Valid @RequestBody MemberDTO memberDTO) {

		return memService.logIntoAccount(memberDTO);
	}

	@PatchMapping("/logout")
	public String logOutMember(@RequestBody MemberDTO memberDto) {

		return memService.logOutFromAccount(memberDto);
	}

	@PutMapping("/update")
	public ResponseEntity<Member> updateMember(@Valid @RequestBody Member member) {

		Member updatedMember = memberService.updatemember(member);

		return new ResponseEntity<Member>(updatedMember, HttpStatus.OK);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteMember(@Valid @RequestBody MemberDTO memberDTO) {

		String response = memberService.deletemember(memberDTO);

		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	@PostMapping("/getmeber/mobile")
	public ResponseEntity<List<Member>> getMemberByMobileNum(@RequestBody MemberDTO memDTO ) {

		List<Member> memList = memberService.getMemberByMobileNo(memDTO);

		return new ResponseEntity<List<Member>>(memList, HttpStatus.OK);
	}

	@PostMapping("/bookappointment")
	public ResponseEntity<AppoinmetDTO> bookAppointment(@Valid @RequestBody AppoinmetDTO appDto) {

		AppoinmetDTO dto = appService.addAppointMentDetails(appDto);

		return new ResponseEntity<AppoinmetDTO>(dto, HttpStatus.CREATED);

	}

	@DeleteMapping("/cancelappointment")
	public ResponseEntity<String> cancelAppointment(@Valid @RequestBody AppoinmetDTO appDto) {

		String response = appService.deleteAppointMent(appDto);

		return new ResponseEntity<String>(response, HttpStatus.OK);

	}

	@PostMapping("/appointmentdetails")
	public ResponseEntity<List<AppoinmetDTO>> getAllAppointment(@RequestBody AppoinmetDTO appDto) {

		List<AppoinmetDTO> appointments = appService.getAllAppointmentsOfMember(appDto);

		return new ResponseEntity<List<AppoinmetDTO>>(appointments, HttpStatus.OK);

	}

	@GetMapping("/allcenters")
	public ResponseEntity<List<VaccineCenterDTO>> getVaccinecenter() {

		return new ResponseEntity<List<VaccineCenterDTO>>(memberService.getAllVaccineCenter(), HttpStatus.OK);
	}

	@GetMapping("/centername/{name}")
	public ResponseEntity<VaccineCenterDTO> getVaccinecenter(@PathVariable("name") String vacineCenterName) {

		return new ResponseEntity<VaccineCenterDTO>(memberService.getVaccineCenterByCenterName(vacineCenterName),
				HttpStatus.OK);
	}

}
