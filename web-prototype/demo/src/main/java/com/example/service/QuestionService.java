package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Question;
import com.example.model.SingleQuestionSingleAnswer;
import com.example.repository.QuestionRepository;
import com.example.repository.SingleQuestionSingleAnswerRepository;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private SingleQuestionSingleAnswerRepository sqsaRepository;
	
	
	public List<Question> getAllQuestions(int gameId){
		List<Question> questions = new ArrayList<>();
		questionRepository.findByGameId(gameId)
		.forEach(questions::add);
		return questions;
	}

	public List<SingleQuestionSingleAnswer> getAllQuestions2(int gameId){
		List<SingleQuestionSingleAnswer> questions = new ArrayList<>();
		sqsaRepository.findByGameId(gameId)
		.forEach(questions::add);
		return questions;
	}

	
	public Question getQuestion(int questionId){
	    return questionRepository.findOne(questionId);
	}
	
	public void addQuestion(Question question){
		questionRepository.save(question);
	}
	
	public void updateQuestion(Question question){
		questionRepository.save(question);
	}

	public void deleteQuestion(int questionId){
		questionRepository.delete(questionId);
	}
	
}
