package com.covidapp.module;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vaccine {
	
	@Id	
	private int vaccineId;
	private String vaccineName;
	private String Description;
	
	@OneToOne(cascade = CascadeType.ALL)
	private VaccineCount vc;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	private VaccinationRegistration vacReg;
	
}
