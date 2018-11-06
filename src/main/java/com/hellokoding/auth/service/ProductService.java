package com.hellokoding.auth.service;

import java.util.Optional;

import com.hellokoding.auth.model.Product;


public interface ProductService {
	void save(Product product);

	

	Iterable<Product> findAll();

	Long count();

	Product findById(Long id);

	void delete(Long id);
}
