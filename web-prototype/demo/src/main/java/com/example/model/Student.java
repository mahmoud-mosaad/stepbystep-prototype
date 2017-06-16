package com.example.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Student extends User{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int id;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "student_game", 
				joinColumns = @JoinColumn(name = "student_id"), 
				inverseJoinColumns = @JoinColumn(name = "game_id"))
	private Set<Game> games;
	
	@ElementCollection
	@CollectionTable(name = "student_game",
	                 joinColumns = @JoinColumn(name = "student_id"))
	@Column(name = "score")
	private Set<Integer> scores;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "student_course", 
				joinColumns = @JoinColumn(name = "student_id"), 
				inverseJoinColumns = @JoinColumn(name = "course_id"))
	private Set<Course> courses;
	
	
	public Student(){
		
	}
	
	public Student(int id, Set<Game> games, Set<Integer> scores) {
		super();
		this.id = id;
		this.games = games;
		this.scores = scores;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Game> getGames() {
		return games;
	}

	public void setGames(Set<Game> games) {
		this.games = games;
	}

	public Set<Integer> getScores() {
		return scores;
	}

	public void setScores(Set<Integer> scores) {
		this.scores = scores;
	}
	
}
