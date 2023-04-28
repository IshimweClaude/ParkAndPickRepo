package com.livestock.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.livestock.entities.Animal;
import com.livestock.entities.SlaughterHouse;

public interface AnimalRepository extends JpaRepository<Animal,Long>{

	List<Animal> findAnimalBySlaughterId(int id);
}
