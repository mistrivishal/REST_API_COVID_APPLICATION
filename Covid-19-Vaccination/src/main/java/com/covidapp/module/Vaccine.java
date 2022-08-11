package com.covidapp.module;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vaccine {
		
	private int vaccineId;
	
	@Pattern(regexp="^[A-Z][a-z]*", message = "Invalid city name - should not contain special characters.")
	private String vaccineName;
	
	@Pattern(regexp="^[A-Z][a-z]*", message = "Invalid city name - should not contain special characters.")
	private String Description;
	
	@OneToOne(cascade = CascadeType.ALL)
	private VaccineCount vc;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	private VaccinationRegistration vacReg;
	
}
