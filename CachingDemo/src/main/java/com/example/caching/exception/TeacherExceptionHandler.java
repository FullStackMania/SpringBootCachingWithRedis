package com.example.caching.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class TeacherExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(TeacherNotFoundException.class)
	public ResponseEntity<Object> handleStudentNotFound(Exception ex, WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(),
				ex.getMessage());

		return handleExceptionInternal(ex, exceptionResponse, null, HttpStatus.NOT_FOUND, request);
	}

}
