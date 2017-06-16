package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.GameChange;
import com.example.repository.GameChangeRepository;

@Service
public class GameChangeService {

	@Autowired
	private GameChangeRepository gameChangeRepository;
	
	public List<GameChange> getAllGameChanges(int gameId){
		List<GameChange> gameChanges = 
				gameChangeRepository.findByGameId(gameId);
		return gameChanges;
	}
	
	public GameChange getGameChange(int gameChangeId){
		return gameChangeRepository.findOne(gameChangeId);
	}
	
	public void addGameChange(GameChange gameChange){
		gameChangeRepository.save(gameChange);
	}
	
	public void updateGameChange(GameChange gameChange){
		gameChangeRepository.save(gameChange);
	}

	public void deleteGameChange(int gameChangeId){
		gameChangeRepository.delete(gameChangeId);
	}
	
}
