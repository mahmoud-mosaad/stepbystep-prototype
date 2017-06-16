package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Game;
import com.example.model.GameChange;
import com.example.model.Lesson;
import com.example.model.Question;
import com.example.model.SingleQuestionSingleAnswer;
import com.example.service.GameChangeService;
import com.example.service.QuestionService;
import com.example.service.SingleQuestionSingleAnswerService;

@RestController
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private SingleQuestionSingleAnswerService sqsaService;
	
	@Autowired
	private GameChangeService gameChangeService;
	
	@RequestMapping(method=RequestMethod.GET ,value="/games/{gameId}/questions")
	public List<Question> getAllQuestions(@PathVariable int gameId){
		return questionService.getAllQuestions(gameId);
	}
	
	@RequestMapping(method=RequestMethod.GET ,value="/games/{gameId}/questions/sqsa")
	public List<SingleQuestionSingleAnswer> getAllQuestions2(@PathVariable int gameId){
		return questionService.getAllQuestions2(gameId);
	}
	
	@RequestMapping(method=RequestMethod.GET ,value="/questions/{questionId}")
	public Question getQuestion(@PathVariable int questionId){
		return questionService.getQuestion(questionId);
	}	
	
	@RequestMapping(method=RequestMethod.POST , value="/games/{gameId}/questions")
	public void addQuestion(@RequestBody Question question, @PathVariable int gameId){
		question.setGame(new Game(gameId, "", "", "",new Lesson(),0));
		questionService.addQuestion(question);
	}
	
	@RequestMapping(method=RequestMethod.POST , value="/games/{gameId}/questions/sqsa")
	public void addQuestion2(@RequestBody SingleQuestionSingleAnswer question, @PathVariable int gameId){
		question.setGame(new Game(gameId, "", "", "",new Lesson(),0));
		sqsaService.addQuestion(question);
		
		GameChange change = new GameChange();
		change.setGameId(gameId);
		change.setActionId(5);
		//change.setTeacherId(collaboratorId);
		//change.setQuestionId(questionId);
		gameChangeService.addGameChange(change);
	}
	
	@RequestMapping(method=RequestMethod.PUT , value="/questions/{questionId}")
	public void updateQuestion(@RequestBody Question question, @PathVariable int questionId){
		Question q = getQuestion(questionId);
		question.setGame(new Game(q.getGame().getId(),q.getGame().getName(), q.getGame().getDescription(),q.getGame().getType(), q.getGame().getLesson(),0));
		questionService.updateQuestion(question);
		
		GameChange change = new GameChange();
		//change.setGameId(gameId);
		change.setActionId(6);
		//change.setTeacherId(collaboratorId);
		change.setQuestionId(questionId);
		gameChangeService.addGameChange(change);
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE , value="/questions/{questionId}")
	public void deleteQuestion(@PathVariable int questionId){
		questionService.deleteQuestion(questionId);
		
		//GameChange change = new GameChange();
		//change.setGameId(gameId);
		//change.setActionId(6);
		//change.setTeacherId(collaboratorId);
		//change.setQuestionId(questionId);
		//gameChangeService.addGameChange(change);
	}
	
}
