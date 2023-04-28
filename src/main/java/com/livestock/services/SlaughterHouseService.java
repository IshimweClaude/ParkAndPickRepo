package com.livestock.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.livestock.entities.Animal;
import com.livestock.entities.SlaughterHouse;
import com.livestock.repositories.AnimalRepository;
import com.livestock.repositories.SlaughterHouserRepository;

@Service
public class SlaughterHouseService {

	@Autowired
	private SlaughterHouserRepository repository;
	@Autowired
	private AnimalRepository animalRepository;
	public String registerSlaughterHouse(SlaughterHouse slaughterHouse) {
        
        repository.save(slaughterHouse);
        return "SlaughterHouse added to system ";
    }
	
	public List<SlaughterHouse> findAllSlaughterHouses(){
		
		return repository.findAll();
	}
	public SlaughterHouse findSlaughterHouseByName(String name) {
		return repository.findSlaughterHouseByName(name).get();
	}
	
	public List<Animal> findAnimalBySlaughterhouseName(String name){
		SlaughterHouse slaughterHouse = repository.findSlaughterHouseByName(name).get();
		return animalRepository.findAnimalBySlaughterId(slaughterHouse.getId());
	}
}
