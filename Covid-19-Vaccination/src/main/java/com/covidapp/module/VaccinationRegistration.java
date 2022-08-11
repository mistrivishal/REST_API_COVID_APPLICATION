package com.covidapp.module;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VaccinationRegistration {
	
	@NotNull(message = "Mobile field should not be empty")
	@Pattern(regexp = "^[789]\\d{9}$", message = "Invalid Mobile No.")
	private long mobileno;
	
	@NotNull(message = "date field should not be empty")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "MM/dd/yyyy")
	private LocalDate dateofregistration;
	
	@OneToMany(mappedBy = "vacReg", cascade = CascadeType.ALL)
	private List<Member> members;
}
