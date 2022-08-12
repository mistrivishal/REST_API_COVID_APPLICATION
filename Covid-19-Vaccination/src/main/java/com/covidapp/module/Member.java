package com.covidapp.module;

import java.time.LocalDate;
import java.util.List;

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
	private Integer memberId;
	
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
	private IdCard idcard;

	@ManyToOne(cascade = CascadeType.ALL)
	private VaccinationRegistration vaccinationReg;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Vaccine vaccine;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "member")
	private List<Appointment> appointments;
}
