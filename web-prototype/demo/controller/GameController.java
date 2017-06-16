package com.stepbystep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stepbystep.model.Course;
import com.stepbystep.model.Game;
import com.stepbystep.model.Lesson;
import com.stepbystep.service.GameService;

@RestController
public class GameController {
	
	@Autowired
	private GameService gameService;
	
	@RequestMapping(method=RequestMethod.GET ,value="/topics/{topicId}/courses/{courseId}/lessons/{lessonId}/games")
	public List<Game> getAllGames(@PathVariable int lessonId){
		return gameService.getAllGames(lessonId);
	}
	
	@RequestMapping(method=RequestMethod.GET ,value="/topics/{topicId}/courses/{courseId}/lessons/{lessonId}/games/{gameId}")
	public Game getGame(@PathVariable int lessonId, @PathVariable int gameId){
		return gameService.getGame(lessonId, gameId);
	}
	
	@RequestMapping(method=RequestMethod.POST , value="/topics/{topicId}/courses/{courseId}/lessons/{lessonId}/games")
	public void addGame(@RequestBody Game game, @PathVariable int courseId, @PathVariable int lessonId){
		game.setLesson(new Lesson(lessonId, "", "", new Course()));
		gameService.addGame(game);
	}
	
	@RequestMapping(method=RequestMethod.PUT , value="/topics/{topicId}/courses/{courseId}/lessons/{lessonId}/games/{gameId}")
	public void updateGame(@RequestBody Game game, @PathVariable int courseId, @PathVariable int lessonId, @PathVariable int gameId){
		game.setLesson(new Lesson(lessonId, "", "", new Course()));
		gameService.updateGame(game);
	}
	
	@RequestMapping(method=RequestMethod.DELETE , value="/topics/{topicId}/courses/{courseId}/lessons/{lessonId}/games/{gameId}")
	public void deleteGame(@PathVariable int gameId){
		gameService.deleteGame(gameId);
	}
	/*
	@RequestMapping(method=RequestMethod.GET ,value="/topics/{topicId}/courses/{courseId}/lessons/{lessonId}/games/{gameId}")
	public void playGame(@PathVariable int lessonId, @PathVariable int gameId , Student student){
		Game game = gameService.getGame(lessonId, gameId);
	}*/
	
}
