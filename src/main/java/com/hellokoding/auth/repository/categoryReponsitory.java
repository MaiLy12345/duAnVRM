package com.hellokoding.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hellokoding.auth.model.Category;

// khai lop tuong tac vơi csdl trong spring boot cho lop du an
public interface categoryReponsitory extends JpaRepository<Category, Long>{

}
