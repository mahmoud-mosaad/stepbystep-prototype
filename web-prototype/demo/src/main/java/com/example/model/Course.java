package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int id;
	
	private String name;
	private String description;
	
	@ManyToOne
	private Topic topic;
	
	@ManyToOne
	private User teacher;
	
	public Course(){
		
	}

	public Course(int id, String name, String description, Topic topic, User user) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.topic = topic;
		this.teacher = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public User getUser() {
		return teacher;
	}

	public void setUser(User teacher) {
		this.teacher = teacher;
	}

}
