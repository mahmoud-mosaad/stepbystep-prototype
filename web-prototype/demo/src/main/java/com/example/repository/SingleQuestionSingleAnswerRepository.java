package com.example.repository;

import java.util.List;

import javax.transaction.Transactional;

import com.example.model.SingleQuestionSingleAnswer;


@Transactional
public interface SingleQuestionSingleAnswerRepository extends QuestionBaseRepository<SingleQuestionSingleAnswer>{
	
	List<SingleQuestionSingleAnswer> findByGameId(int gameId);

}
