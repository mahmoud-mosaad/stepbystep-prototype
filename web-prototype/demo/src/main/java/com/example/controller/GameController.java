package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Collaborator;
import com.example.model.Comment;
import com.example.model.Course;
import com.example.model.Game;
import com.example.model.GameChange;
import com.example.model.Lesson;
import com.example.model.SingleQuestionSingleAnswer;
import com.example.service.CollaboratorService;
import com.example.service.CommentService;
import com.example.service.GameChangeService;
import com.example.service.GameService;
import com.example.service.QuestionService;

@RestController
public class GameController {
	
	@Autowired
	private GameService gameService;
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private CollaboratorService collaboratorService;
	
	@Autowired
	private GameChangeService gameChangeService;
	
	@Autowired 
	private QuestionService questionService;
	
	@RequestMapping(method=RequestMethod.GET ,value="/topics/{topicId}/courses/{courseId}/lessons/{lessonId}/games")
	public List<Game> getAllGames(@PathVariable int lessonId){
		return gameService.getAllGames(lessonId);
	}
	
	@RequestMapping(method=RequestMethod.GET ,value="/lessons/{lessonId}/games")
	public List<Game> getAllGames2(@PathVariable int lessonId){
		List<Game> dupgames = gameService.getAllGames(lessonId);
		List<Game> games = new ArrayList<Game>();
		for(int i=0;i<dupgames.size();i++){
			if (dupgames.get(i).getTrash() == 0){
				games.add(dupgames.get(i));
			}
		}
		return games;
	}
	
	@RequestMapping(method=RequestMethod.GET ,value="/games/{gameId}/changes")
	public List<GameChange> getAllChanges(@PathVariable int gameId){
		return gameChangeService.getAllGameChanges(gameId);
	}
	
	@RequestMapping(method=RequestMethod.GET ,value="/topics/{topicId}/courses/{courseId}/lessons/{lessonId}/games/{gameId}")
	public Game getGame(@PathVariable int lessonId, @PathVariable int gameId){
		return gameService.getGame(lessonId, gameId);
	}
	
	@RequestMapping(method=RequestMethod.GET ,value="/games/{gameId}")
	public Game getGame2(@PathVariable int gameId){
		return gameService.getOneGame(gameId);
	}
	
	
	@RequestMapping(method=RequestMethod.POST , value="/topics/{topicId}/courses/{courseId}/lessons/{lessonId}/games")
	public void addGame(@RequestBody Game game, @PathVariable int courseId, @PathVariable int lessonId){
		game.setLesson(new Lesson(lessonId, "", "", new Course()));
		gameService.addGame(game);
	}
	
	@RequestMapping(method=RequestMethod.POST , value="/lessons/{lessonId}/games")
	public void addGame2(@RequestBody Game game, @PathVariable int lessonId){
		game.setLesson(new Lesson(lessonId, "", "", new Course()));
		gameService.addGame(game);
	}

	@RequestMapping(method=RequestMethod.POST , value="/games/{gameId}/comment/{userId}")
	public void addComment(@RequestBody Comment comment, @PathVariable int gameId, @PathVariable int userId){
		comment.setGameId(gameId);
		comment.setUserId(userId);
		commentService.addComment(comment);
	}

	@RequestMapping(method=RequestMethod.POST , value="/games/{gameId}/collaborator/{collaboratorId}")
	public void addCollaborator(@RequestBody Collaborator collaborator, @PathVariable int gameId, @PathVariable int collaboratorId){
		collaborator.setGameId(gameId);
		collaborator.setCollaboratorId(collaboratorId);
		collaboratorService.addCollaborator(collaborator);
		GameChange change = new GameChange();
		change.setGameId(gameId);
		change.setActionId(1);
		change.setQuestionId(collaboratorId);
		gameChangeService.addGameChange(change);
	}
	
	@RequestMapping(method=RequestMethod.PUT , value="/topics/{topicId}/courses/{courseId}/lessons/{lessonId}/games/{gameId}")
	public void updateGame(@RequestBody Game game, @PathVariable int courseId, @PathVariable int lessonId, @PathVariable int gameId){
		game.setLesson(new Lesson(lessonId, "", "", new Course()));
		gameService.updateGame(game);
	}
	
	@RequestMapping(method=RequestMethod.PUT , value="/games/{gameId}")
	public void updateGame2(@RequestBody Game game, @PathVariable int gameId){
		Game gm = getGame2(gameId);
		game.setLesson(new Lesson(gm.getLesson().getId(), "", gm.getType(), new Course()));
		gameService.updateGame(game);
		GameChange change;
		if (!gm.getName().equals(game.getName())){
			change = new GameChange();
			change.setGameId(gameId);
			change.setActionId(3);
			//change.setTeacherId(collaboratorId);
			change.setChange(gm.getName());
			gameChangeService.addGameChange(change);
		}
		if (!gm.getDescription().equals(game.getDescription())){
			change = new GameChange();
			change.setGameId(gameId);
			change.setActionId(4);
			//change.setTeacherId(collaboratorId);
			change.setChange(gm.getDescription());
			gameChangeService.addGameChange(change);
		}
	}
	
	@RequestMapping(method=RequestMethod.DELETE , value="/topics/{topicId}/courses/{courseId}/lessons/{lessonId}/games/{gameId}")
	public void deleteGame(@PathVariable int gameId){
		gameService.deleteGame(gameId);
	}
	
	@RequestMapping(method=RequestMethod.DELETE , value="/games/{gameId}")
	public void deleteGame2(@PathVariable int gameId){
		gameService.deleteGame(gameId);
	}
	
	@RequestMapping(method=RequestMethod.PUT , value="/games/{gameId}/cancel")
	public void cancelGame(@PathVariable int gameId){
		Game gm = getGame2(gameId);
		gm.setTrash(1);
		gameService.updateGame(gm);
		GameChange change = new GameChange();
		change.setGameId(gameId);
		change.setActionId(2);
		gameChangeService.addGameChange(change);
	}
	
	@RequestMapping(method=RequestMethod.PUT , value="/games/{gameId}/restore")
	public void restoreGame(@PathVariable int gameId){
		Game gm = getGame2(gameId);
		gm.setTrash(0);
		gameService.updateGame(gm);
	}

	@RequestMapping(method=RequestMethod.POST , value="/games/{gameId}/copy")
	public void copyGame(@PathVariable int gameId){
		Game gm = getGame2(gameId);
		Game gm2 = new Game();
		gm2.setName(gm.getName());
		gm2.setDescription(gm.getDescription());
		gm2.setType(gm.getType());
		gm2.setLesson(gm.getLesson());
		gm2.setTrash(gm.getTrash());
		gameService.addGame(gm);
	}
	
	/*
	@RequestMapping(method=RequestMethod.GET ,value="/topics/{topicId}/courses/{courseId}/lessons/{lessonId}/games/{gameId}")
	public void playGame(@PathVariable int lessonId, @PathVariable int gameId , Student student){
		Game game = gameService.getGame(lessonId, gameId);
	}*/
	
}
