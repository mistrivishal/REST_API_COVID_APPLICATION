package com.cowin.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Pattern;

import com.cowin.utils.AdharCard;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer memberId;

	@Pattern(regexp = "(0/91)?[7-9][0-9]{9}", message = "Invalid Mobile No.")
	private String mobileno;

	private String passWord;

	@OneToOne(cascade = CascadeType.ALL)
	private AdharCard adharcard;

	@OneToMany
	@JoinColumn(name = "memberId_FK", referencedColumnName = "memberId")
	@JsonIgnore
	List<Appointment> appointments = new ArrayList<>();

}

//1 mobile ---> 5 members ----> appointments;