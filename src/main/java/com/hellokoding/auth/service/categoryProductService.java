package com.hellokoding.auth.service;

import com.hellokoding.auth.model.Category;

public interface categoryProductService {
	void save(Category category);

	Iterable<Category> findAll();

	Long count();

	Category findByID(long id);

	void delete(long id);
}
