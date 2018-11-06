package com.hellokoding.auth.service;

import com.hellokoding.auth.model.categoryProduct;

public interface categoryProductService {
void save(categoryProduct category);
Iterable<categoryProduct> findAll();
Long count();
categoryProduct findByID(long id);
void delete(long id);
}
