package com.stepbystep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stepbystep.model.Course;
import com.stepbystep.model.Topic;
import com.stepbystep.model.User;
import com.stepbystep.service.CourseService;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	
	@RequestMapping(value="/courses")
	public List<Course> getAllCoursesOfAllTopics(){
		return courseService.getAllCoursesOfAllTopics();
	}
	
	@RequestMapping(method=RequestMethod.GET , value="/topics/{topicId}/courses")
	public List<Course> getAllCourses(@PathVariable int topicId){
		return courseService.getAllCourses(topicId);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{courseId}")
	public Course getCourse(@PathVariable int topicId, @PathVariable int courseId){
		return courseService.getCourse(topicId, courseId);
	}
	
	@RequestMapping(method=RequestMethod.POST , value="/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable int topicId){
		course.setTopic(new Topic(topicId, "", ""));
		//course.setUser(new User(teacherId ,"","","","","","","","" , 0 , null));
		courseService.addCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.PUT , value="/topics/{topicId}/courses/{courseId}")
	public void updateCourse(@RequestBody Course course, @PathVariable int topicId, @PathVariable int courseId){
		course.setId(courseId);
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE , value="/topics/{topicId}/courses/{courseId}")
	public void deleteCourse(@PathVariable int courseId){
		courseService.deleteCourse(courseId);
	}
	
}
