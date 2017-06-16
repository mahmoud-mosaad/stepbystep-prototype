package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Teacher extends User{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int id;
	
	public Teacher(){
		 
	}

	public Teacher(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
