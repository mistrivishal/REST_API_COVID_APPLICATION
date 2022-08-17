package com.cowin.exceptions;

@SuppressWarnings("serial")
public class MemberNotFoundException extends RuntimeException{

	public MemberNotFoundException() {
		
	}
	
	public MemberNotFoundException(String msg) {
		
		super(msg);
	}
}
