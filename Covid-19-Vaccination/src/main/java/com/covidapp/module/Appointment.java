package com.covidapp.module;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bookingId;
	
	@NotBlank(message = "Mobile number Field is mandatory")
	@Pattern(regexp="^[789][0-9]{10}$", message = "Iavalid mobileno...")
	private Long mobileno;
	
	@NotEmpty(message = "Date field should not be empty")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "MM/dd/yyyy")
	private LocalDate dateofbooking;
	
	@NotNull(message = "Select either one option")
	private Boolean bookingstatus;
	
	@ManyToOne(cascade = CascadeType.ALL)
	VaccinationCenter vaccinationCenter;
	
	@ManyToOne(cascade = CascadeType.ALL)
	Member member;
	
}
