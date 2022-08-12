package com.covidapp.module;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
		private int centerCcode;
		
		@NotNull(message = "Center name is not valid")
		@Pattern(regexp="^[A-Z][a-z]*", message = "Invalid city name - should not contain special characters.")
		private String centername;
		
		@Embedded
		@Pattern(regexp="^[A-Z][a-z]*", message = "Invalid city name - should not contain special characters.")
		private Address VaccinCeneterAddress; 
		
		@OneToOne(cascade = CascadeType.ALL)
		private VaccineInventory VaccineInventory;
		
		@OneToMany(cascade = CascadeType.ALL, mappedBy = "vaccinationCenter")
		private List<Appointment> appointments;
}
