package com.hellokoding.auth.repository;

import com.hellokoding.auth.model.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


//khai lop tuong tac vơi csdl trong spring boot user
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    
    Optional<User> findByToken(String token);
}
