package com.diel.products_inventory.exceptions;

public class EntityNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String message;

	public EntityNotFoundException() {
		this.message = "Entity not found";
	}

	public String getMessage() {
		return message;
	}

}
