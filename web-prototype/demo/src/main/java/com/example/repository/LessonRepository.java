package com.example.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Lesson;

public interface LessonRepository extends CrudRepository<Lesson,Integer> {
	
	public List<Lesson> findByCourseId(int courseId);
	
}
