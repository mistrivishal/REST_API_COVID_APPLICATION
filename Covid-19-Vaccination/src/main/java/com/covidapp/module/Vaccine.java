package com.covidapp.module;

import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vaccine {
		
	private int vaccineId;
	private String vaccineName;
	private String Description;
	
	@OneToOne
	private VaccineCount vc;
	
}
