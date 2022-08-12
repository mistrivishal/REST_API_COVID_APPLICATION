package com.covidapp.module;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	private int vaccineId;
	
	@Pattern(regexp="^[A-Z][a-z][0-9]*", message = "Invalid city name - should not contain special characters.")
	private String vaccineName;
	
	@Pattern(regexp="^[A-Z][a-z][0-9]*", message = "Invalid city name - should not contain special characters.")
	private String Description;
	
	@OneToOne(cascade = CascadeType.ALL)
	private VaccineCount vaccineCount;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "vaccine")
	private List<Member> member;
	
}
