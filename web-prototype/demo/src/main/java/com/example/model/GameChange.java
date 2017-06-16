package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GameChange {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int id;
	
	private int gameId;
	
	private int teacherId;
	
	private int actionId;
	
	private int questionId;
	
	private String change;

	public GameChange(){
		
	}

	public GameChange(int id, int gameId, int teacherId, int actionId, int questionId, String change) {
		super();
		this.id = id;
		this.gameId = gameId;
		this.teacherId = teacherId;
		this.actionId = actionId;
		this.questionId = questionId;
		this.change = change;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public int getActionId() {
		return actionId;
	}

	public void setActionId(int actionId) {
		this.actionId = actionId;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getChange() {
		return change;
	}

	public void setChange(String change) {
		this.change = change;
	}
		
}
