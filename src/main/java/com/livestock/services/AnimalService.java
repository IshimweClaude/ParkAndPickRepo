package com.livestock.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.livestock.entities.Animal;
import com.livestock.repositories.AnimalRepository;

@Service
public class AnimalService {

	@Autowired
	private AnimalRepository repository;
	
	public String registerAnimal(Animal animal) {
        
        repository.save(animal);
        return "animal added to system ";
    }
	
	public List<Animal> getAll(){
		
		return repository.findAll();
	}
	

}
