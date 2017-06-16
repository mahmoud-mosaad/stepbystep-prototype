package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Game {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int id;
	
	private String name;
	private String description;
	private String type;

	@ManyToOne//(cascade = CascadeType.ALL)
	//@JoinTable(name = "game_lesson", joinColumns = @JoinColumn(name = "game_id"), inverseJoinColumns = @JoinColumn(name = "lesson_id"))
	private Lesson lesson;
	
	private int trash;
	
	public Game(){
		
	}

	public Game(int id, String name, String description, String type, Lesson lesson, int trash) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.type = type;
		this.lesson = lesson;
		this.trash = trash;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Lesson getLesson() {
		return lesson;
	}

	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}

	public int getTrash() {
		return trash;
	}

	public void setTrash(int trash) {
		this.trash = trash;
	}

}
