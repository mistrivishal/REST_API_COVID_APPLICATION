package com.covidapp.module;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccineInventory {
	
	
	private LocalDate date;
	
	@OneToOne
	private VaccinationCenter vac;	
	
	@OneToMany(mappedBy = "vacReg",cascade = CascadeType.ALL)
	private List<Vaccine> vaccines;
}
