package com.covidapp.module;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
	
	@NotBlank(message = "Address field should not be empty")
	@Pattern(regexp="^[A-Z][a-z][0-9][:-/,]*", message = "]")
	private String address;
	
	@NotBlank(message = "city field should not be empty")
	@Pattern(regexp="^[A-Z][a-z]*", message = "Iavalid city name - should not contain special characters.")
	private String city;
	
	@NotBlank(message = "state field should not be empty")
	@Pattern(regexp="^[A-Z][a-z]*", message = "Iavalid city name - should not contain special characters.")
	private String state;
	
	@NotBlank(message = "pincode field should not be empty")
	@Pattern(regexp="^[1-9][0-9]{5}$", message = "Iavalid pincode..")
	private String pincde;
}
