package com.cowin.exceptions;

@SuppressWarnings("serial")
public class InvalidDateException extends RuntimeException{

	public InvalidDateException() {
		// TODO Auto-generated constructor stub
	}
	
	public InvalidDateException(String msg) {
		super(msg);
	}
}

