package com.hellokoding.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hellokoding.auth.model.Category;

// khai lop tuong tac vơi csdl trong spring boot cho lop du an
@Repository
public interface categoryReponsitory extends JpaRepository<Category, Long>{

}
