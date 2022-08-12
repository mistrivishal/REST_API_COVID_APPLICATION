package com.covidapp.exceptionhandler;

@SuppressWarnings("serial")
public class IdCardNotFoundException extends RuntimeException{
	
	public IdCardNotFoundException() {
		
	}
	
	public IdCardNotFoundException(String msg) {
		super(msg);
	}
}
