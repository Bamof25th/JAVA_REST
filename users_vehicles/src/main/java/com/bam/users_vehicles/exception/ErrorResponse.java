package com.bam.users_vehicles.exception;


import java.time.LocalDateTime;

import org.springframework.http.HttpStatusCode;

import lombok.Data;

@Data
public class ErrorResponse {
	private String message;
	private String details;
	private LocalDateTime timestamp;
	private HttpStatusCode statusCode;

	public ErrorResponse(String message, String details, HttpStatusCode statusCode) {
		this.message = message;
		this.details = details;
		this.timestamp = LocalDateTime.now();
		this.statusCode = statusCode;
	}

    public ErrorResponse(String message2, String details2, int value) {
        //TODO Auto-generated constructor stub
    }
}
