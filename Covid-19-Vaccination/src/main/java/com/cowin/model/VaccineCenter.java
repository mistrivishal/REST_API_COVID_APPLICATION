package com.cowin.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.transaction.Transactional;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.cowin.utils.Address;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Transactional
public class VaccineCenter {

	@Id
	@Column(unique = true)
	private Integer center_id;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "MM/dd/yyyy")
	private LocalDate date;

	@Column(unique = true)
	@Size(min = 3, max = 22, message = "name length not match min:3,max:22")
	private String vacCenterName;

	private Address center_address;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "center_id_fk", referencedColumnName = "center_id")
	private List<Vaccine> vaccine;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_center_id", referencedColumnName = "center_id")
	@JsonIgnore
	List<Appointment> appointments = new ArrayList<>();

}
