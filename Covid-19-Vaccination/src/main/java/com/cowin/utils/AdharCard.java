package com.cowin.utils;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class AdharCard {

	@Id
	@Column(unique = true)
	@Pattern(regexp = "^[2-9]{1}[0-9]{3}[0-9]{4}[0-9]{4}$", message = "Invalid Aadhaar Number.")
	private String adharNo;

	@Size(min = 3, max = 255, message = "Your name should contain minimum 3 letters and max 255.")
	@Pattern(regexp = "^[A-Za-z]+$", message = "Iavalid name - name should not contain special characters.")
	private String name;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
	private Date dob;

	@Pattern(regexp = "^(?:m|M|male|Male|f|F|female|Female)$")
	private String gender;

	@Pattern(regexp = "^[A-Za-z]+$", message = "Iavalid addressline name - should not contain special characters.")
	private String addressline;

	@Pattern(regexp = "^[A-Za-z]+$", message = "Iavalid city name - should not contain special characters.")
	private String city;

	@Pattern(regexp = "^[A-Za-z]+$", message = "Iavalid state name - should not contain special characters.")
	private String state;

	@Pattern(regexp = "^[1-9][0-9]{5}$", message = "Iavalid pincode..")
	private String pincode;
}
