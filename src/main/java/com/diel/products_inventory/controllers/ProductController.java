package com.diel.products_inventory.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diel.products_inventory.entities.Product;
import com.diel.products_inventory.helpers.ResponseHelper;
import com.diel.products_inventory.services.ProductService;

@RestController
@RequestMapping("products")
public class ProductController {
	private ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("list")
	public ResponseEntity<ResponseHelper> findAll() {
		return this.productService.findAll();
	}

	@GetMapping("find/{id}")
	public ResponseEntity<ResponseHelper> findById(@PathVariable Long id) {
		return this.productService.findById(id);
	}

	@PostMapping("insert")
	public ResponseEntity<ResponseHelper> save(@RequestBody Product product) {
		return this.productService.save(product);
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<ResponseHelper> delete(@PathVariable Long id) {
		return this.productService.delete(id);
	}

	@PutMapping("update")
	public ResponseEntity<ResponseHelper> update(@RequestBody Product product) {
		return this.productService.update(product);
	}
}
