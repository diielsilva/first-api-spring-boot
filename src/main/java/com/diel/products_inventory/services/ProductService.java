package com.diel.products_inventory.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Vector;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.diel.products_inventory.entities.Product;
import com.diel.products_inventory.exceptions.InvalidFieldsException;
import com.diel.products_inventory.helpers.ResponseHelper;
import com.diel.products_inventory.repositories.ProductRepository;

@Service
public class ProductService {
	private ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;

	}

	public ResponseEntity<ResponseHelper> findAll() {
		ResponseHelper responseHelper = new ResponseHelper(HttpStatus.OK.value(), "Request successfully",
				this.productRepository.findAll());
		return new ResponseEntity<ResponseHelper>(responseHelper, HttpStatus.OK);
	}

	public ResponseEntity<ResponseHelper> findById(Long id) {
		ArrayList<Product> list = new ArrayList<Product>();
		Product product = this.productRepository.findById(id).get();
		list.add(product);
		ResponseHelper responseHelper = new ResponseHelper(HttpStatus.OK.value(), "Request successfully", list);
		return new ResponseEntity<ResponseHelper>(responseHelper, HttpStatus.OK);

	}

	@Transactional
	public ResponseEntity<ResponseHelper> save(Product product) {
		if (product.getId() != null || product.getCreatedAt() != null || product.getUpdatedAt() != null) {
			throw new InvalidFieldsException();
		} else if (product.getDescription().isEmpty() || product.getDescription() == null || product.getPrice() == null
				|| product.getAmount() == null) {
			throw new InvalidFieldsException();
		} else if (product.getAmount() < 1 || product.getPrice() <= 0) {
			throw new InvalidFieldsException();
		} else {
			product.setCreatedAt(LocalDate.now());
			product.setUpdatedAt(LocalDate.now());
			this.productRepository.save(product);
			ResponseHelper responseHelper = new ResponseHelper(HttpStatus.CREATED.value(), "Product saved successfully",
					new Vector<Void>());
			return new ResponseEntity<ResponseHelper>(responseHelper, HttpStatus.CREATED);
		}
	}

	@Transactional
	public ResponseEntity<ResponseHelper> delete(Long id) {
		if (id == null) {
			throw new InvalidFieldsException();
		} else {
			this.productRepository.deleteById(id);
			ResponseHelper responseHelper = new ResponseHelper(HttpStatus.OK.value(), "Product deleted successfully",
					new Vector<Void>());
			return new ResponseEntity<ResponseHelper>(responseHelper, HttpStatus.OK);
		}
	}

	@Transactional
	public ResponseEntity<ResponseHelper> update(Product product) {
		if (product.getId() == null) {
			throw new InvalidFieldsException();
		} else if (product.getCreatedAt() != null || product.getUpdatedAt() != null) {
			throw new InvalidFieldsException();
		} else if (product.getDescription() == null || product.getDescription().isEmpty() || product.getPrice() == null
				|| product.getAmount() == null) {
			throw new InvalidFieldsException();
		} else if (product.getAmount() < 1 || product.getPrice() <= 0) {
			throw new InvalidFieldsException();
		} else {
			Product databaseProduct = this.productRepository.findById(product.getId()).get();
			product.setCreatedAt(databaseProduct.getCreatedAt());
			product.setUpdatedAt(LocalDate.now());
			this.productRepository.save(product);
			ResponseHelper responseHelper = new ResponseHelper(HttpStatus.OK.value(), "Product updated successfully",
					new Vector<Void>());
			return new ResponseEntity<ResponseHelper>(responseHelper, HttpStatus.OK);
		}
	}
}
