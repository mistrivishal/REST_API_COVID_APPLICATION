package com.cowin.exceptions;

@SuppressWarnings("serial")
public class VaccineCenterNotFound extends RuntimeException{

	public VaccineCenterNotFound() {
		
	}
	
	public VaccineCenterNotFound(String msg) {
		super (msg);
	}
}
