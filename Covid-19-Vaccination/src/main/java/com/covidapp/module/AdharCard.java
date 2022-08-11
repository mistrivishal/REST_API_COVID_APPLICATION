package com.covidapp.module;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdharCard {
	
	private long adharNo;
	private String fingerprints;
	private String irisscan;
}
