package com.cowin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vaccine {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer vaccineId;

	@Pattern(regexp = "^[a-zA-Z0-9_]*$", message = "Invalid Vaccine Name")
	private String vaccineName;

	@Min(0)
	private Double price;

	@Min(0)
	private Integer vaccineCount;

}
