package com.livestock.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity

public class Animal {
	@Id
	private int animal_id;
	private String type;
	private String weight;
	@Column
	private int slaughterId;
	public int getAnimal_id() {
		return animal_id;
	}
	public void setAnimal_id(int animal_id) {
		this.animal_id = animal_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public int getSlaughter_id() {
		return slaughterId;
	}
	public void setSlaugher_id(int slaugher_id) {
		this.slaughterId = slaugher_id;
	}
	
	
	
}
