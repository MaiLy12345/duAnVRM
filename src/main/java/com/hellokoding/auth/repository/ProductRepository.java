package com.hellokoding.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hellokoding.auth.model.Product;


//khai lop tuong tac vơi csdl trong spring boot cho lop product
public interface ProductRepository extends JpaRepository<Product, Long>{

}
