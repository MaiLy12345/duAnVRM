package com.hellokoding.auth.repository;

import com.hellokoding.auth.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;


//khai lop tuong tac vơi csdl trong spring boot cho lop role
public interface RoleRepository extends JpaRepository<Role, Long>{
}
