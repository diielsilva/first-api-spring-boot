package com.diel.products_inventory.exceptions;

public class UnexpectedException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String message;

	public UnexpectedException() {
		this.message = "Unexpected error";
	}

	public String getMessage() {
		return this.message;
	}

}
