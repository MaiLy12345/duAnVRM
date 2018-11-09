package com.hellokoding.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hellokoding.auth.model.Category;
import com.hellokoding.auth.repository.categoryReponsitory;

@Service
public class categoryServiceImpl implements categoryProductService{

	@Autowired
	private categoryReponsitory categoryReponsitory;

	@Override
	public void save(Category category) {
		// TODO Auto-generated method stub
		categoryReponsitory.save(category);
		
	}

	@Override
	public Iterable<Category> findAll() {
		// TODO Auto-generated method stub
		return categoryReponsitory.findAll();
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return categoryReponsitory.count();
	}

	@Override
	public Category findByID(long id) {
		// TODO Auto-generated method stub
		return categoryReponsitory.findOne(id);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		categoryReponsitory.delete(id);
	}
	
	
}
