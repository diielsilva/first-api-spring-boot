package com.diel.products_inventory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diel.products_inventory.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
