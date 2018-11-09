package com.hellokoding.auth.repository;

import com.hellokoding.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


//khai lop tuong tac vơi csdl trong spring boot user
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
