package com.covidapp.module;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdCard {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idCardid;
	
	@NotNull(message = "Name field should not be empty..")
	@Size(min=3,max=255, message = "Your name should contain minimum 3 letters and max 255.")
	@Pattern(regexp="^[A-Z][a-z]*", message = "Iavalid name - name should not contain special characters.")
	private String name;
	
	@NotNull(message = "date field should not be empty")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "MM/dd/yyyy")
	private LocalDate dob;
	
	@NotNull(message = "gender field should not be empty")
	private String gender;
	
	@Embedded
	private Address Address;
	
	@Embedded
	private PanCard pan;
	
	@Embedded
	private AdharCard adhar;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "idcard")
	private Member member;


}
