package com.covidapp.exceptionhandler;

public class IdCardNotFoundException extends RuntimeException{
	
	public IdCardNotFoundException() {
		
	}
	
	public IdCardNotFoundException(String msg) {
		super(msg);
	}
}
