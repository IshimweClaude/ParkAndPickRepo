package com.livestock.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.livestock.entities.User;



public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findByEmail(String email);
}
