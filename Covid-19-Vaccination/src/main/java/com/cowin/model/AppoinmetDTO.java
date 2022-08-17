package com.cowin.model;

import java.sql.Date;

import javax.validation.constraints.FutureOrPresent;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class AppoinmetDTO {
	
	private String mobileNo;
	
	private String adharNo;
	
	private String vaccineName;
	
	private String vacineCenterName;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "MM/dd/yyyy")
	@FutureOrPresent(message = "Book date should not be in past..")
	private Date DateOfBooking;
	
}
