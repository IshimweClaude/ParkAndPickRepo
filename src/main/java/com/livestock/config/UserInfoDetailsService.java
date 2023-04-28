package com.livestock.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.livestock.entities.User;
import com.livestock.repositories.UserRepository;



@Component
public class UserInfoDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository repository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<User> UserInfo = repository.findByEmail(username);
		return UserInfo.map(UserInfoUserDetails::new)
				.orElseThrow(()-> new UsernameNotFoundException("user not found"));
	}

}
