package com.covidapp.module;

import java.time.LocalDate;

import javax.persistence.*;

import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdCard {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private LocalDate dob;
	private String gender;
	private Address Address;
	private PanCard pan;
	private AdharCard adhar;


}
