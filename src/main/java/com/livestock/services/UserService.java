package com.livestock.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.livestock.entities.User;
import com.livestock.repositories.UserRepository;



@Service
public class UserService {

	 @Autowired
	    private UserRepository repository;

	    @Autowired
	    private PasswordEncoder passwordEncoder;
	
	public String addUser(User userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        repository.save(userInfo);
        return "user added to system ";
    }
}
