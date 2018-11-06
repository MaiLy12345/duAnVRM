package com.hellokoding.auth.service;

import org.springframework.stereotype.Service;

import com.hellokoding.auth.model.categoryProduct;
import com.hellokoding.auth.repository.categoryReponsitory;

@Service
public class categoryServiceImpl implements categoryProductService{

	categoryReponsitory categoryReponsitory;
	@Override
	public void save(categoryProduct category) {
		// TODO Auto-generated method stub
		categoryReponsitory.save(category);
	}

	@Override
	public Iterable<categoryProduct> findAll() {
		// TODO Auto-generated method stub
		
		return categoryReponsitory.findAll();
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return categoryReponsitory.count();
	}

	@Override
	public categoryProduct findByID(long id) {
		// TODO Auto-generated method stub
		return categoryReponsitory.getOne(id);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		categoryReponsitory.delete(id);
		
	}

}
