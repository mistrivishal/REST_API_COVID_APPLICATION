package com.covidapp.module;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccineInventory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer invid;
	
	private LocalDate date;
	
	@OneToOne
	private VaccinationCenter vac;	
	
	@OneToMany(mappedBy = "vacReg",cascade = CascadeType.ALL)
	private List<Vaccine> vaccines;
}
