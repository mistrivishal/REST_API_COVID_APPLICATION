package com.covidapp.exceptionhandler;

@SuppressWarnings("serial")
public class DuplicateIdException extends RuntimeException{

	public DuplicateIdException() {
		
	}
	
	public DuplicateIdException(String msg) {
		super(msg);
	}
}
