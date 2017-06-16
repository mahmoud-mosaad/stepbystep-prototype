package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Course;
import com.example.model.Lesson;
import com.example.model.Topic;
import com.example.model.User;
import com.example.service.LessonService;

@RestController
public class LessonController {

	@Autowired
	private LessonService lessonService;
	
	@RequestMapping("/topics/{topicId}/courses/{courseId}/lessons")
	public List<Lesson> getAllLessons(@PathVariable int courseId){
		return lessonService.getAllLessons(courseId);
	}
	
	@RequestMapping("/courses/{courseId}/lessons")
	public List<Lesson> getAllLessons2(@PathVariable int courseId){
		return lessonService.getAllLessons(courseId);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{courseId}/lessons/{lessonId}")
	public Lesson getLesson(@PathVariable int courseId, @PathVariable int lessonId){
		return lessonService.getLesson(courseId, lessonId);
	}
	
	@RequestMapping("/lessons/{lessonId}")
	public Lesson getLesson2(@PathVariable int lessonId){
		return lessonService.getOneLesson(lessonId);
	}
	
	@RequestMapping(method=RequestMethod.POST , value="/topics/{topicId}/courses/{courseId}/lessons")
	public void addLesson(@RequestBody Lesson lesson, @PathVariable int topicId, @PathVariable int courseId){
		lesson.setCourse(new Course(courseId, "", "", new Topic(), new User()));
		lessonService.addLesson(lesson);
	}
	
	@RequestMapping(method=RequestMethod.POST , value="/courses/{courseId}/lessons")
	public void addLesson(@RequestBody Lesson lesson, @PathVariable int courseId){
		lesson.setCourse(new Course(courseId, "", "", new Topic(), new User()));
		lessonService.addLesson(lesson);
	}
	
	@RequestMapping(method=RequestMethod.PUT , value="/topics/{topicId}/courses/{courseId}/lessons/{lessonId}")
	public void updateLesson(@RequestBody Lesson lesson, @PathVariable int topicId, @PathVariable int courseId, @PathVariable int lessonId){
		lesson.setCourse(new Course(courseId, "", "" , new Topic() ,new User()));
		lessonService.updateLesson(lesson);
	}
	
	@RequestMapping(method=RequestMethod.PUT , value="/lessons/{lessonId}")
	public void updateLesson2(@RequestBody Lesson lesson, @PathVariable int lessonId){
		Lesson lsn = getLesson2(lessonId);
		lesson.setCourse(new Course(lsn.getCourse().getId(), "", "" , new Topic() ,new User()));
		lessonService.updateLesson(lesson);
	}
	
	@RequestMapping(method=RequestMethod.DELETE , value="/topics/{topicId}/courses/{courseId}/lessons/{lessonId}")
	public void deleteLesson(@PathVariable int lessonId){
		lessonService.deleteLesson(lessonId);
	}
	
	@RequestMapping(method=RequestMethod.DELETE , value="/lessons/{lessonId}")
	public void deleteLesson2(@PathVariable int lessonId){
		lessonService.deleteLesson(lessonId);
	}
	
}
