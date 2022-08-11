package com.covidapp.module;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer mid;
	
	@NotNull
	private Boolean dose1status;

	@NotNull
	private Boolean dose2status;

	@NotNull(message = "date field should not be empty")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "MM/dd/yyyy")
	private LocalDate dose1date;

	@NotNull(message = "date field should not be empty")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "MM/dd/yyyy")
	private LocalDate dose2date;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "IdCard")
	private IdCard idcard;

	@ManyToOne(cascade = CascadeType.ALL)
	private VaccinationRegistration vacReg;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Vaccine vaccine;
}
