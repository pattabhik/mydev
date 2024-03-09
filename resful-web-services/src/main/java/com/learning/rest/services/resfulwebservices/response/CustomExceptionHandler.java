package com.learning.rest.services.resfulwebservices.response;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author Pattabhi
 */
@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleExption(Exception exp, WebRequest request) {
		ErrorResponse error = new ErrorResponse(LocalDateTime.now(), exp.getMessage(), request.getDescription(false));
		return new ResponseEntity<Object>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
			HttpStatusCode status, WebRequest request) {
		StringBuilder strBldr = new StringBuilder();
		ex.getFieldErrors().stream().forEach(error -> strBldr.append(error.getDefaultMessage()).append(", "));
		ErrorResponse error = new ErrorResponse(LocalDateTime.now(), strBldr.toString(), request.getDescription(true));
		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
	}
}
