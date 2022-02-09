package com.diel.products_inventory.handlers;

import java.util.NoSuchElementException;
import java.util.Vector;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.diel.products_inventory.exceptions.EntityNotFoundException;
import com.diel.products_inventory.exceptions.InvalidFieldsException;
import com.diel.products_inventory.exceptions.UnexpectedException;
import com.diel.products_inventory.helpers.ResponseHelper;

@ControllerAdvice
public class ManagerExceptionHandler {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ResponseHelper> entityNotFoundException(EntityNotFoundException exception) {
		ResponseHelper responseHelper = new ResponseHelper(HttpStatus.NOT_FOUND.value(), exception.getMessage(),
				new Vector<Void>());
		return new ResponseEntity<ResponseHelper>(responseHelper, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InvalidFieldsException.class)
	public ResponseEntity<ResponseHelper> invalidFieldsException(InvalidFieldsException exception) {
		ResponseHelper responseHelper = new ResponseHelper(HttpStatus.BAD_REQUEST.value(), exception.getMessage(),
				new Vector<Void>());
		return new ResponseEntity<ResponseHelper>(responseHelper, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ResponseHelper> noSuchElementException(NoSuchElementException exception) {
		EntityNotFoundException entityNotFoundException = new EntityNotFoundException();
		ResponseHelper responseHelper = new ResponseHelper(HttpStatus.NOT_FOUND.value(),
				entityNotFoundException.getMessage(), new Vector<Void>());
		return new ResponseEntity<ResponseHelper>(responseHelper, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<ResponseHelper> emptyResultDataAccessException(EmptyResultDataAccessException exception) {
		EntityNotFoundException entityNotFoundException = new EntityNotFoundException();
		ResponseHelper responseHelper = new ResponseHelper(HttpStatus.NOT_FOUND.value(),
				entityNotFoundException.getMessage(), new Vector<Void>());
		return new ResponseEntity<ResponseHelper>(responseHelper, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseHelper> unexpectedException(Exception exception) {
		UnexpectedException unexpectedException = new UnexpectedException();
		ResponseHelper responseHelper = new ResponseHelper(HttpStatus.INTERNAL_SERVER_ERROR.value(),
				unexpectedException.getMessage(), new Vector<Void>());
		return new ResponseEntity<ResponseHelper>(responseHelper, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
