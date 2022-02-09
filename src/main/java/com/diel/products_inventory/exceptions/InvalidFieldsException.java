package com.diel.products_inventory.exceptions;

public class InvalidFieldsException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String message;

	public InvalidFieldsException() {
		this.message = "Invalid fields";
	}

	public String getMessage() {
		return this.message;
	}

}
