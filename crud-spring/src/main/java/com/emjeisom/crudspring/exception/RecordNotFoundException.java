package com.emjeisom.crudspring.exception;

public class RecordNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public RecordNotFoundException(Long id) {
		super("Record not found. Id: " + id + ".");
	}
	
}
