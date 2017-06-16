package com.example.repository;

import java.util.List;

import javax.transaction.Transactional;

import com.example.model.Question;

@Transactional
public interface QuestionRepository extends QuestionBaseRepository<Question> {
	List<Question> findByGameId(int gameId);
}
