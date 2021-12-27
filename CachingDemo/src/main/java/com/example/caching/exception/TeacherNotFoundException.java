package com.example.caching.exception;

public class TeacherNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TeacherNotFoundException(String message) {
		super(message);
	}

	public TeacherNotFoundException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
