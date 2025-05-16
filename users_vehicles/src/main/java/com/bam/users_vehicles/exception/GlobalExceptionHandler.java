package com.bam.users_vehicles.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bam.users_vehicles.utils.ApplicationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> notFoundResource(ResourceNotFoundException ex) {
		ErrorResponse err = new ErrorResponse(ex.getMessage(), "Resource not found please check !",
				HttpStatusCode.valueOf(404));
		return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<?> handleIllegalArgument(IllegalArgumentException ex) {
		ErrorResponse err = new ErrorResponse(ex.getMessage(), "Invalid argument", HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ApplicationException.class)
	public ResponseEntity<?> handleApplicationException(ApplicationException ex) {
		ErrorResponse err = new ErrorResponse(ex.getMessage(), "Application error", HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleAll(Exception ex) {
		ErrorResponse err = new ErrorResponse(ex.getMessage(), "Internal server error",
				HttpStatus.INTERNAL_SERVER_ERROR.value());
		return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
