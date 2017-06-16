package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Course;
import com.example.repository.CourseRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourses(int topicId){
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId)
		.forEach(courses::add);
		System.out.println("success????");
		return courses;
	}
	
	public List<Course> getAllCoursesOfAllTopics(){
		List<Course> courses = new ArrayList<>();
		courseRepository.findAll()
		.forEach(courses::add);
		return courses;
	}

	public Course getOneCourse(int courseId){
		return courseRepository.findOne(courseId);
	}
	
	public Course getCourse(int topicId, int courseId){
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId)
		.forEach(courses::add);
		return courses.stream().filter(crs -> crs.getId() == courseId).findFirst().get();
	    //return courseRepository.findOne(courseId);
	}
	
	public void addCourse(Course course){
		courseRepository.save(course);
	}
	
	public void updateCourse(Course course){
		courseRepository.save(course);
	}

	public void deleteCourse(int courseId){
		courseRepository.delete(courseId);
	}
	
}
