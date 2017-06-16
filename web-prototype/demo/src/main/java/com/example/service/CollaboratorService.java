package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Collaborator;
import com.example.model.Comment;
import com.example.repository.CollaboratorRepository;

@Service
public class CollaboratorService {

	@Autowired
	private CollaboratorRepository collaboratorRepository;
	
	public List<Collaborator> getAllCollaborators(int gameId){
		List<Collaborator> collaborators = 
				collaboratorRepository.findByGameId(gameId);
		return collaborators;
	}
	
	public Collaborator getCollaborator(int collaboratorId){
		return collaboratorRepository.findOne(collaboratorId);
	}
	
	public void addCollaborator(Collaborator collaborator){
		collaboratorRepository.save(collaborator);
	}
	
	public void updateCollaborator(Collaborator collaborator){
		collaboratorRepository.save(collaborator);
	}

	public void deleteCollaborator(int collaboratorId){
		collaboratorRepository.delete(collaboratorId);
	}
	
	
}
