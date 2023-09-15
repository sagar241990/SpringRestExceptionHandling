package com.example.sag.exceptions;

public class ErrorResponse {
	
	String errorMessage;
	String HttpErrorCode;
	
	
	public ErrorResponse(String errorMessage, String httpErrorCode) {
		super();
		this.errorMessage = errorMessage;
		HttpErrorCode = httpErrorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getHttpErrorCode() {
		return HttpErrorCode;
	}
	public void setHttpErrorCode(String httpErrorCode) {
		HttpErrorCode = httpErrorCode;
	}

	

}
