package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Lesson;
import com.example.repository.LessonRepository;

@Service
public class LessonService {

	@Autowired
	private LessonRepository lessonRepository;
	
	public List<Lesson> getAllLessons(int courseId){
		List<Lesson> lessons = new ArrayList<>();
		lessonRepository.findByCourseId(courseId)
		.forEach(lessons::add);
		return lessons;
	}
	
	public Lesson getLesson(int courseId, int lessonId){
		List<Lesson> lessons = new ArrayList<>();
		lessonRepository.findByCourseId(courseId)
		.forEach(lessons::add);
		return lessons.stream().filter(lsn -> lsn.getId() == lessonId).findFirst().get();
	    //return courseRepository.findOne(courseId);
	}
	
	public Lesson getOneLesson(int lessonId){
		return lessonRepository.findOne(lessonId);
	}
	
	
	public void addLesson(Lesson lesson){
		lessonRepository.save(lesson);
	}
	
	public void updateLesson(Lesson lesson){
		lessonRepository.save(lesson);
	}

	public void deleteLesson(int lessonId){
		lessonRepository.delete(lessonId);
	}
	
}
