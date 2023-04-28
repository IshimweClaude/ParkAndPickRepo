package com.livestock.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.livestock.entities.SlaughterHouse;

public interface SlaughterHouserRepository extends JpaRepository<SlaughterHouse,String >{

 
	Optional<SlaughterHouse> findSlaughterHouseByName(String name);
}
