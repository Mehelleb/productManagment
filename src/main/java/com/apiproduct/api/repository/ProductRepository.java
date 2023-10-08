package com.apiproduct.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.apiproduct.api.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	
	

}
