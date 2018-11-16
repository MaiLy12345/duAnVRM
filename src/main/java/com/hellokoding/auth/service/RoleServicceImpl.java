package com.hellokoding.auth.service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hellokoding.auth.model.Role;
import com.hellokoding.auth.repository.RoleRepository;

@Service
@Transactional
public class RoleServicceImpl implements RoleService{

	@Autowired
	private RoleRepository roleRepsitory;

	

	@Override
	public Iterable<Role> findAll() {
		// TODO Auto-generated method stub
		return roleRepsitory.findAll();
	}
	

}
