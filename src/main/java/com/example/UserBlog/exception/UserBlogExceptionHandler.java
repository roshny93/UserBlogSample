package com.example.UserBlog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class UserBlogExceptionHandler {
	
	@ExceptionHandler(UserBlogException.class)
	public final ResponseEntity<ExceptionResponse> handleTradeServiceException(UserBlogException e,
			WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(e.getMessage());
		if("Invalid User".equals(e.getMessage())) {
			return new ResponseEntity<>(exceptionResponse, HttpStatus.UNAUTHORIZED);	
		}
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
	
}
