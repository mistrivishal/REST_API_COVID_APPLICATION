package com.cowin.utils;

import javax.persistence.Embeddable;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

	@Pattern(regexp = "^[A-Z][a-z][0-9][:-/,]*", message = "]")
	private String address;

	@Pattern(regexp = "^[A-Z][a-z]*", message = "Iavalid city name - should not contain special characters.")
	private String city;

	@Pattern(regexp = "^[A-Z][a-z]*", message = "Iavalid city name - should not contain special characters.")
	private String state;

	@Pattern(regexp = "^[1-9][0-9]{5}$", message = "Iavalid pincode..")
	private String pincode;
}
