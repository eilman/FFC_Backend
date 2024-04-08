package com.ffc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ffc.entity.Users;
import com.ffc.repository.UserRepository;

@Service
public class UserService {
	
	UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<Users> getAllUsers() {
		return userRepository.findAll();
		
	}

	public Users getUser(Long userId) {
		return userRepository.findById(userId).orElse(null);
	}
	
	

}
