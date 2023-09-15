package com.example.sag.exceptions;

public class CustException extends RuntimeException{
	String mess ;

	public CustException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustException(String message) {
		super(message);
		mess = message;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return mess;
	}
	
}
