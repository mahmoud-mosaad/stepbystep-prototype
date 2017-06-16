package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.ManyToOne;

@Entity
@Inheritance
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int id;
	
	private int score;
	private String type;
	
	@ManyToOne//(cascade = CascadeType.ALL)
	/*@JoinTable(name = "question_game", 
	joinColumns = @JoinColumn(name = "question_id"), 
	inverseJoinColumns = @JoinColumn(name = "game_id"))
	*/
	private Game game;
	
	//@ManyToMany//(cascade = CascadeType.ALL)
	/*@JoinTable(name = "question_sqsa", 
				joinColumns = @JoinColumn(name = "question_id"), 
				inverseJoinColumns = @JoinColumn(name = "sqsa_id"))
	*/
	//private Set<SingleQuestionSingleAnswer> sqsas;
	
	//@ManyToMany//(cascade = CascadeType.ALL)
	/*@JoinTable(name = "question_sqma", 
				joinColumns = @JoinColumn(name = "question_id"), 
				inverseJoinColumns = @JoinColumn(name = "sqma_id"))
	*/
	//private Set<SingleQuestionMultipleAnswer> sqmas;
	
	//@ManyToMany//(cascade = CascadeType.ALL)
	/*@JoinTable(name = "question_mqma", 
				joinColumns = @JoinColumn(name = "question_id"), 
				inverseJoinColumns = @JoinColumn(name = "mqma_id"))
	*/
	//private Set<MultipleQuestionMultipleAnswer> mqmas;
	
	public Question(){
		 
	}

	public Question(int id, int score, String type, Game game) {
		super();
		this.id = id;
		this.score = score;
		this.type = type;
		this.game = game;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

}
