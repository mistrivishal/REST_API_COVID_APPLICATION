package com.covidapp.module;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccinationCenter {
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int code;
		private String centername;
		
		@Embedded
		private Address address; 
		
		@OneToOne
		private VaccineInventory vi;
}
