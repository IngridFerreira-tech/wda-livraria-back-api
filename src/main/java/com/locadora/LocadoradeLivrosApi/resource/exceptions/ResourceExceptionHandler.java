package com.locadora.LocadoradeLivrosApi.resource.exceptions;

import javax.servlet.ServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.locadora.LocadoradeLivrosApi.service.exceptions.DataIntegrityViolationException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<StandardError>dataIntegrityViolationException(DataIntegrityViolationException e, ServletRequest request){
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
					 e.getMessage());
	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);				 
	}

}
