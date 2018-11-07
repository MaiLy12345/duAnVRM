package com.hellokoding.auth.service;



import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import com.hellokoding.auth.model.User;

public interface UserService {
	
	void save(User user);

	User findByUsername(String email);

	Iterable<User> findAll();

	Long count();

	User findById(Long id);

	void delete(Long id);
}
