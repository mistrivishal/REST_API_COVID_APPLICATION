package com.cowin.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class MemberDTO {
	
	@NotNull(message = "Mobile field should not be empty")
	@Pattern(regexp = "(0/91)?[7-9][0-9]{9}", message = "Invalid Mobile No.")
	private String mobileno;
	
//	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")
	private String passWord;

	private String adharNo;
}
