package com.covidapp.module;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdharCard {
	
	@NotNull(message = "Missing or empty value - Adhar Number.")
	@Pattern(regexp = "^[2-9]{1}[0-9]{3}\\s[0-9]{4}\\s[0-9]{4}$", message = "Invalid Aadhaar Number.")
	private long adharNo;
	
//	private String fingerprints;
//	private String irisscan;
}
