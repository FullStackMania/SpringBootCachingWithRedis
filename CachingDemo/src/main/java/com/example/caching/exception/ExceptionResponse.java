package com.example.caching.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ExceptionResponse {
	private LocalDateTime timestamp;
	private int errorCode;
	private String message;
}
