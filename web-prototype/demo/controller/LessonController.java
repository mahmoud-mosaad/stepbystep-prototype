package com.stepbystep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stepbystep.model.Course;
import com.stepbystep.model.Lesson;
import com.stepbystep.model.Teacher;
import com.stepbystep.model.Topic;
import com.stepbystep.service.LessonService;

@RestController
public class LessonController {

	@Autowired
	private LessonService lessonService;
	
	@RequestMapping("/topics/{topicId}/courses/{courseId}/lessons")
	public List<Lesson> getAllLessons(@PathVariable int courseId){
		return lessonService.getAllLessons(courseId);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{courseId}/lessons/{lessonId}")
	public Lesson getLesson(@PathVariable int courseId, @PathVariable int lessonId){
		return lessonService.getLesson(courseId, lessonId);
	}
	
	@RequestMapping(method=RequestMethod.POST , value="/topics/{topicId}/courses/{courseId}/lessons")
	public void addLesson(@RequestBody Lesson lesson, @PathVariable int topicId, @PathVariable int courseId){
		lesson.setCourse(new Course(courseId, "", "", new Topic() ));
		lessonService.addLesson(lesson);
	}
	
	@RequestMapping(method=RequestMethod.PUT , value="/topics/{topicId}/courses/{courseId}/lessons/{lessonId}")
	public void updateLesson(@RequestBody Lesson lesson, @PathVariable int topicId, @PathVariable int courseId, @PathVariable int lessonId){
		lesson.setCourse(new Course(courseId, "", "" , new Topic() ));
		lessonService.updateLesson(lesson);
	}
	
	@RequestMapping(method=RequestMethod.DELETE , value="/topics/{topicId}/courses/{courseId}/lessons/{lessonId}")
	public void deleteLesson(@PathVariable int lessonId){
		lessonService.deleteLesson(lessonId);
	}
	
}
