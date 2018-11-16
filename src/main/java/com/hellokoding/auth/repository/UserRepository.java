package com.hellokoding.auth.repository;

import com.hellokoding.auth.model.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//khai lop tuong tac vơi csdl trong spring boot user
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    
    Optional<User> findByToken(String token);
}
