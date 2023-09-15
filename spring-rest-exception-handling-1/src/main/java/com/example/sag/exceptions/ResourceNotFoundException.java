package com.example.sag.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	
	private String message;

	public ResourceNotFoundException() {
		super();
	}

	public ResourceNotFoundException(String message) {
		super(message);
		this.message = message;
	}

}
