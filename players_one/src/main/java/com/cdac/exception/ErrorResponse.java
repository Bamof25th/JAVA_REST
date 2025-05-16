package com.cdac.exception;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ErrorResponse {
	private String message;
	private String details;
	private LocalDateTime timestamp;
	private int statusCode;

	public ErrorResponse(String message, String details, int statusCode) {
		this.message = message;
		this.details = details;
		this.timestamp = LocalDateTime.now();
		this.statusCode = statusCode;
	}

	
}
