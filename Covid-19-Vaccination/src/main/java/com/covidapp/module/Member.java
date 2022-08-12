package com.covidapp.module;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

//	@NotNull(message = "date field should not be empty")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "MM/dd/yyyy")
	private LocalDate dose1date;

//	@NotNull(message = "date field should not be empty")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "MM/dd/yyyy")
	private LocalDate dose2date;
	
	@OneToOne(cascade = CascadeType.ALL)
	private IdCard idcard;

//	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private VaccinationRegistration vaccinationReg;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private Vaccine vaccine;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "member")
	private List<Appointment> appointments;
}
