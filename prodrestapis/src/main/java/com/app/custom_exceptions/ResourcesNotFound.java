package com.app.custom_exceptions;

public class ResourcesNotFound extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourcesNotFound(String message) {
		super(message);
	}

}
