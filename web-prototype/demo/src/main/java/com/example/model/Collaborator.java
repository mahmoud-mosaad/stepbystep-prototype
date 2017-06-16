package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Collaborator {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int id;
	
	private int gameId;
	
	private int collaboratorId;

	public Collaborator(){
		
	}

	public Collaborator(int id, int gameId, int collaboratorId) {
		super();
		this.id = id;
		this.gameId = gameId;
		this.collaboratorId = collaboratorId;
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

	public int getCollaboratorId() {
		return collaboratorId;
	}

	public void setCollaboratorId(int collaboratorId) {
		this.collaboratorId = collaboratorId;
	}
	
}
