package com.example.repository;

import javax.transaction.Transactional;

import com.example.model.SingleQuestionMultipleAnswer;

@Transactional
public interface SingleQuestionMultipleAnswerRepository extends QuestionBaseRepository<SingleQuestionMultipleAnswer>{

}
