package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.SingleQuestionSingleAnswer;
import com.example.repository.SingleQuestionSingleAnswerRepository;

@Service
public class SingleQuestionSingleAnswerService {

	@Autowired
	private SingleQuestionSingleAnswerRepository sqsaRepository;
	
	public List<SingleQuestionSingleAnswer> getAllSQSAQuestions(int gameId){
		List<SingleQuestionSingleAnswer> questions = new ArrayList<>();
		sqsaRepository.findByGameId(gameId)
		.forEach(questions::add);
		return questions;
	}

	public SingleQuestionSingleAnswer getQuestion(int questionId){
	    return sqsaRepository.findOne(questionId);
	}
	
	public void addQuestion(SingleQuestionSingleAnswer question){
		sqsaRepository.save(question);
	}
	
	public void updateQuestion(SingleQuestionSingleAnswer question){
		sqsaRepository.save(question);
	}

	public void deleteQuestion(int questionId){
		sqsaRepository.delete(questionId);
	}
	
}
