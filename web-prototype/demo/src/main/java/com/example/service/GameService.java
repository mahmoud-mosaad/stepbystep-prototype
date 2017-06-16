package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Game;
import com.example.repository.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;
	
	public List<Game> getAllGames(int lessonId){
		List<Game> games = new ArrayList<>();
		gameRepository.findByLessonId(lessonId)
		.forEach(games::add);
		return games;
	}
	
	public Game getGame(int lessonId, int gameId){
		List<Game> lessons = new ArrayList<>();
		gameRepository.findByLessonId(lessonId)
		.forEach(lessons::add);
		return lessons.stream().filter(lsn -> lsn.getId() == gameId).findFirst().get();
	    //return courseRepository.findOne(courseId);
	}

	public Game getOneGame(int gameId){
	    return gameRepository.findOne(gameId);
	}
	
	public void addGame(Game game){
		gameRepository.save(game);
	}
	
	public void updateGame(Game game){
		gameRepository.save(game);
	}

	public void deleteGame(int gameId){
		gameRepository.delete(gameId);
	}

	
}
