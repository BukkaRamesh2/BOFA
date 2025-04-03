package com.bofa.exception;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class CustomerGlobalException {

	public CustomerGlobalException() {
		// TODO Auto-generated constructor stub
	}
	
	@ExceptionHandler(ResponseStatusException.class)
	public ResponseEntity<Object> handleStatusException(ResponseStatusException ex){
		return buildErrorResponse(ex.getReason(), ex.getStatusCode().value());
		
	}

	private ResponseEntity<Object> buildErrorResponse(String reason, int statusCode) {
		Map<String, Object> errorRes = new LinkedHashMap<>();
		errorRes.put("status", statusCode);
		errorRes.put("error", reason);		
		return new ResponseEntity<>(errorRes, HttpStatus.valueOf(statusCode));
	}
	
	

}
