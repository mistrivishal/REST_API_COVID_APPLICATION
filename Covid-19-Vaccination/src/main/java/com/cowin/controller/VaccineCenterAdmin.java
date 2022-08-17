package com.cowin.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cowin.model.VaccineCenter;
import com.cowin.model.VaccineCenterDTO;
import com.cowin.service.VaccineCenterService;

@RestController
@RequestMapping("/admin")
public class VaccineCenterAdmin {

	@Autowired
	private VaccineCenterService vaccinecenterservice;

	@PostMapping("/savecenter")
	public ResponseEntity<VaccineCenter> saveVaccinecenter(@Valid @RequestBody VaccineCenter vac) {

		VaccineCenter center = vaccinecenterservice.saveVaccineCenter(vac);

		return new ResponseEntity<VaccineCenter>(center, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<VaccineCenter> updateVaccinecenter(@Valid @RequestBody VaccineCenter vac) {

		VaccineCenter center = vaccinecenterservice.updateVaccineCenter(vac);

		return new ResponseEntity<VaccineCenter>(center, HttpStatus.CREATED);
	}

	@DeleteMapping("/removecenter")
	public ResponseEntity<Boolean> deleteVaccinecenter(@RequestBody VaccineCenterDTO vacCenterDTO) {
		

		return new ResponseEntity<Boolean>(vaccinecenterservice.deleteVaccineCenter(vacCenterDTO), HttpStatus.OK);

	}

	@PostMapping("/getcenterbyid")
	public ResponseEntity<VaccineCenter> getVaccinecenterByCenterId(@RequestBody VaccineCenterDTO vacCenterDTO) {

		return new ResponseEntity<VaccineCenter>(vaccinecenterservice.getVaccineCenterById(vacCenterDTO),
				HttpStatus.OK);
	}

	@GetMapping("/centers")
	public ResponseEntity<List<VaccineCenter>> getVaccinecenter() {

		List<VaccineCenter> centers = vaccinecenterservice.getAllVaccineCenter();

		return new ResponseEntity<List<VaccineCenter>>(centers, HttpStatus.OK);
	}
}	
