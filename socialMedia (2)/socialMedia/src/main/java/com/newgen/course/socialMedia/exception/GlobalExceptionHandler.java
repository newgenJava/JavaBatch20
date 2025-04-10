package com.newgen.course.socialMedia.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Map<String, String>> handleUserNotFoundException(UserNotFoundException ex) {
		Map<String,String> error = new HashMap<>();
		
		error.put("errorMessage", ex.getMessage());
		error.put("errorCode", ex.getErrorCode());
		error.put("currentTime", LocalDateTime.now().toString());
		
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
		
	}

}
