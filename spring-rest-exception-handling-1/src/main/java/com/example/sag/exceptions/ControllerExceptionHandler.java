package com.example.sag.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex) {

		String message = ex.getMessage();
		ErrorResponse err = new ErrorResponse(message, "123");
		return new ResponseEntity<ErrorResponse>(err, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CustException.class)
	public ResponseEntity<ErrorResponse> custExceptionHandler(CustException ex) {
		String message = ex.getMessage();
		ErrorResponse err = new ErrorResponse("Something went wrong internally !! "+ message, "500");
		return new ResponseEntity<ErrorResponse>(err, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public ResponseEntity<ErrorResponse> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex) {
//		String message = ex.getMessage();
//		ErrorResponse err = new ErrorResponse(ex.getLocalizedMessage(), "500");
//		return new ResponseEntity<ErrorResponse>(err, HttpStatus.BAD_REQUEST);
//	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex) {
		Map<String,String> resp = new HashMap<>();
		ex.getBindingResult().getAllErrors()
			.forEach((err)->{
				String fieldName = ((FieldError)err).getField();
				String message = err.getDefaultMessage();
				resp.put(fieldName, message);
			});
		
		return new ResponseEntity<Map<String,String>>(resp, HttpStatus.BAD_REQUEST);
	}
}
