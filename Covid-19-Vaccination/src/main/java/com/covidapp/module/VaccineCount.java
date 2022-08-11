package com.covidapp.module;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccineCount {
	
	@Id
	private Integer vaccount;
	
	private int quantity;
	private double price;
	
	@OneToOne
	private VaccineInventory vi;
}
