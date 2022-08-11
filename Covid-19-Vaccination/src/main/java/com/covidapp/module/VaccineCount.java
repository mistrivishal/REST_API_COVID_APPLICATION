package com.covidapp.module;

import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccineCount {
	
	
	private int quantity;
	private double price;
	@OneToOne
	private VaccineInventory vi;
}
