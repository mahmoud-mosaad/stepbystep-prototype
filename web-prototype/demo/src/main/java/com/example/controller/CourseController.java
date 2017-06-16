package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Course;
import com.example.model.Topic;
import com.example.model.User;
import com.example.service.CourseService;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	
	@RequestMapping(method=RequestMethod.GET , value="/courses")
	public List<Course> getAllCoursesOfAllTopics(){
		return courseService.getAllCoursesOfAllTopics();
	}
	
	@RequestMapping(method=RequestMethod.GET , value="/topics/{topicId}/courses")
	public List<Course> getAllCourses(@PathVariable int topicId){
		return courseService.getAllCourses(topicId);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/courses/{courseId}")
	public Course getOneCourse(@PathVariable int courseId){
		Course course = courseService.getOneCourse(courseId);
		System.out.println(course.getName());
		return course;
	}
	
	@RequestMapping("/topics/{topicId}/courses/{courseId}")
	public Course getCourse(@PathVariable int topicId, @PathVariable int courseId){
		return courseService.getCourse(topicId, courseId);
	}
	
	@RequestMapping(method=RequestMethod.POST , value="/topics/{topicId}/courses/{teacherId}")
	public void addCourse(@RequestBody Course course, @PathVariable int topicId, @PathVariable int teacherId){
		course.setTopic(new Topic(topicId, "", ""));
		course.setUser(new User(teacherId,"","","","","","","","",0,null));
		courseService.addCourse(course);
	}
	
	
	@RequestMapping(method=RequestMethod.PUT , value="/topics/{topicId}/courses/{courseId}")
	public void updateCourse(@RequestBody Course course, @PathVariable int topicId, @PathVariable int courseId){
		course.setId(courseId);
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.PUT , value="/courses/{courseId}")
	public void updateCourse2(@RequestBody Course course, @PathVariable int courseId){
		Course crs = getOneCourse(courseId);
		course.setTopic(crs.getTopic());
		courseService.updateCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE , value="/topics/{topicId}/courses/{courseId}")
	public void deleteCourse(@PathVariable int courseId){
		courseService.deleteCourse(courseId);
	}
	
	@RequestMapping(method=RequestMethod.DELETE , value="/courses/{courseId}")
	public void deleteCourse2(@PathVariable int courseId){
		courseService.deleteCourse(courseId);
	}
	
}
