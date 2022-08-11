package com.covidapp.module;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
		private int code;
		
		@Pattern(regexp="^[A-Z][a-z]*", message = "Invalid city name - should not contain special characters.")
		private String centername;
		
<<<<<<< HEAD
		@Embedded
=======
		@Pattern(regexp="^[A-Z][a-z]*", message = "Invalid city name - should not contain special characters.")
>>>>>>> d81ea913e7159de54b19e16cc4b9e3f36339dcaf
		private Address address; 
		
		@OneToOne
		private VaccineInventory vi;
}
