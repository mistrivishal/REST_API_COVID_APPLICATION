package com.covidapp.module;

import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccinationCenter {
		private int code;
		private String centername;
		private Address address; 
		
		@OneToOne
		private VaccineInventory vi;
}
