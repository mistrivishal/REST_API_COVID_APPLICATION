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
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccineInventory {
<<<<<<< HEAD
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer invid;
	
=======
	
	@NotNull(message = "Date field should not be empty")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "MM/dd/yyyy")
>>>>>>> d81ea913e7159de54b19e16cc4b9e3f36339dcaf
	private LocalDate date;
	
	@OneToOne
	private VaccinationCenter vac;	
	
	@OneToMany(mappedBy = "vacReg",cascade = CascadeType.ALL)
	private List<Vaccine> vaccines;
}
