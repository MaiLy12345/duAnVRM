package com.hellokoding.auth.service;



import com.hellokoding.auth.model.User;

 
public interface UserService {
	//save
	void save(User user);
	
	//fin by username
	User findByUsername(String username);

	// list user
	Iterable<User> findAll();
	
	//Dem
	Long count();
	
	//tim kiem theo id
	User findById(Long id);
	
	//xoa theo id
	void delete(Long id);
}
