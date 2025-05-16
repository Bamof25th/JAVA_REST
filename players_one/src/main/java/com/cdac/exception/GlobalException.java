package com.cdac.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity<?> notFoundResource(ResourceNotFound ex) {

		ErrorResponse err = new ErrorResponse(ex.getMessage(), "resource Not Found Please Check!",
				HttpStatus.NOT_FOUND.value());

		return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<?> handleIllegalArgument(IllegalArgumentException ex) {
		ErrorResponse err = new ErrorResponse(ex.getMessage(), "Invalid argument", HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}
}
