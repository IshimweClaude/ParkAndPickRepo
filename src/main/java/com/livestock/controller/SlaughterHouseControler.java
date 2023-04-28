package com.livestock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.livestock.entities.Animal;
import com.livestock.entities.SlaughterHouse;
import com.livestock.services.SlaughterHouseService;



@RestController
@RequestMapping("/slaughterhouse")
public class SlaughterHouseControler {
	@Autowired
	private SlaughterHouseService slaughterHouseService;
	
	
	@GetMapping("/all")
	public List<SlaughterHouse> findAllSlaughterHouses(){
		
		return slaughterHouseService.findAllSlaughterHouses();
	}
	
	@PostMapping("/register")
	public String registerSlaughterHouses(@RequestBody SlaughterHouse slaughterHouse) {
		return slaughterHouseService.registerSlaughterHouse(slaughterHouse);
		
	}
	
	@GetMapping("/{name}")
	public SlaughterHouse findSlaughterHouseByName(@PathVariable String name) {
		return slaughterHouseService.findSlaughterHouseByName(name);
	}
	
	@GetMapping("animals/{name}")
	public List<Animal> findAnimalBySlaughterhouseName(String name){
		
		return slaughterHouseService.findAnimalBySlaughterhouseName(name);
	}
	
}
