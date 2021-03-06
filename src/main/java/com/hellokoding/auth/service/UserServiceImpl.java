package com.hellokoding.auth.service;

import com.hellokoding.auth.model.User;
import com.hellokoding.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
 
    /*@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;*/

    @Override
    public void save(User user) {
        /*user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));*/
      
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

	@Override
	public Iterable<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public Long count() {
		return userRepository.count();
	}

	@Override
	public User findById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.getOne(id);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		userRepository.delete(id);
	}

	@Override
	public Optional<User> findByToken(String token) {
		// TODO Auto-generated method stub
		return userRepository.findByToken(token);
	}
}
