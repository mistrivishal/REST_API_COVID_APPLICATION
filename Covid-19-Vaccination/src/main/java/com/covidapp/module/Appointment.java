package com.covidapp.module;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Pattern(regexp="^[1-9][0-9]{8}$", message = "Iavalid bookingid...")
	private long bookingid;
	
	@Pattern(regexp="^[789][0-9]{10}$", message = "Iavalid mobileno...")
	private long mobileno;
	
	@NotNull(message = "Date field should not be empty")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "MM/dd/yyyy")
	private LocalDate dateofbooking;
	
	private Slot slot;
	
	@NotNull(message = "Select either one option")
	private boolean bookingstatus;
}
