package com.covidapp.exceptionhandler;


@SuppressWarnings("serial")
public class MemberNotFoundException extends RuntimeException{

	public MemberNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	
	public MemberNotFoundException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}
	
}
