package com.hellokoding.auth.service;


import com.hellokoding.auth.model.Role;

public interface RoleService {	
	Iterable<Role> findAll();
}
