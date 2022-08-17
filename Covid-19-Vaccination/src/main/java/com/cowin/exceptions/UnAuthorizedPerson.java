package com.cowin.exceptions;

@SuppressWarnings("serial")
public class UnAuthorizedPerson extends RuntimeException {

	public UnAuthorizedPerson() {
		// TODO Auto-generated constructor stub
	}
	
	public UnAuthorizedPerson(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}
	
}
