package com.livestock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.livestock.dto.AuthRequest;
import com.livestock.entities.User;
import com.livestock.responses.LoginResponse;
import com.livestock.services.JwtService;
import com.livestock.services.UserService;



@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	 private UserService userService;
	@Autowired
	private JwtService jwtService;
	
	@Autowired
    private AuthenticationManager authenticationManager;

	@GetMapping("/welcome")
	public String welcome() {
		
		return "Welcome to CMDS users";
	}
	 @PostMapping("/new")
	    public String addNewUser(@RequestBody User userInfo){
	        return userService.addUser(userInfo);
	    }
	 
	 @PostMapping("/authenticate")
	    public ResponseEntity<?> authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
		 System.out.println("authenticating .......");
	    Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
	    LoginResponse response=new LoginResponse();		
	    if(authentication.isAuthenticated()) {
	    	String token = jwtService.generateToken(authRequest.getUsername());
	    	response.setToken(token);
	    	return ResponseEntity.ok(response);
	    } else {
	    	throw new UsernameNotFoundException("Invalid user Request!!");
	    }
	    	
	    }
	 
}
