package com.cowin.exceptions;

@SuppressWarnings("serial")
public class DuplicateEntryException extends RuntimeException{

	public DuplicateEntryException() {
		// TODO Auto-generated constructor stub
	}
	
	public DuplicateEntryException(String msg){
		
		super(msg);
	}
}
