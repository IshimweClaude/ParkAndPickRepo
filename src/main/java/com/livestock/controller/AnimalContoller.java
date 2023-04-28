package com.livestock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.livestock.entities.Animal;
import com.livestock.services.AnimalService;

@RestController
@RequestMapping("/animals")
public class AnimalContoller {

	@Autowired
	private AnimalService animalService;
	
	
	@GetMapping("/all")
	public List<Animal> findAllAnimal(){
		
		return animalService.getAll();
	}
	
	@PostMapping("/register")
	public String registeranimalService(@RequestBody Animal animal) {
		return animalService.registerAnimal(animal);
		
	}
}
