package com.example.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Game;

public interface GameRepository extends CrudRepository<Game , Integer>{

	public List<Game> findByLessonId(int lessonId);

	
}
