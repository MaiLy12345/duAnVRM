package com.hellokoding.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hellokoding.auth.model.Category;
import com.hellokoding.auth.model.Product;


//khai lop tuong tac vơi csdl trong spring boot cho lop product
public interface ProductRepository extends JpaRepository<Product, Long>{

}
