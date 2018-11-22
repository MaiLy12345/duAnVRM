package com.hellokoding.auth.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hellokoding.auth.model.Category;
import com.hellokoding.auth.model.Product;
import com.hellokoding.auth.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void save(Product product) {
		// TODO Auto-generated method stub
		productRepository.save(product);
		
	}

	@Override
	public Iterable<Product> findAll() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Long count() {
		return productRepository.count();
		
	}

	@Override
	public Product findById(Long id) {
		// TODO Auto-generated method stub
		return productRepository.getOne(id);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		productRepository.delete(id);
		
	}


	

	


}
