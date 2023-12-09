package com.emjeisom.crudspring.repository;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.emjeisom.crudspring.exception.RecordNotFoundException;

@RestControllerAdvice
public class AplicationControllerAdvice {

	@ExceptionHandler(RecordNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleNotFoundExcepiton(RecordNotFoundException ex) {
		return ex.getMessage();
	}
	
}
