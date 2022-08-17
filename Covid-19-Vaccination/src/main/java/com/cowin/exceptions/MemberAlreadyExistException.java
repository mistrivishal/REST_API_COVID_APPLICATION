package com.cowin.exceptions;

@SuppressWarnings("serial")
public class MemberAlreadyExistException extends RuntimeException{

	public MemberAlreadyExistException() {
		
	}
	
	public MemberAlreadyExistException(String msg) {
		
		super(msg);
	}
}
