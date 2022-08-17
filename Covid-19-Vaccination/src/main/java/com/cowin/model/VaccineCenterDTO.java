package com.cowin.model;

import com.cowin.utils.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class VaccineCenterDTO {

	private Integer center_id;

	private String vacCenterName;

	private Address center_address;

}
