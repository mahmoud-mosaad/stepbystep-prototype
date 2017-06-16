package com.stepbystep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stepbystep.model.Topic;
import com.stepbystep.service.TopicService;

@Controller
public class HomeController {
	
	@Autowired
	private TopicService topicService;
	
	/*
	@RequestMapping(method=RequestMethod.GET, value="/getTopics")
	public String getTopic(Model model){
		
		List<Topic> topics = topicService.getAllTopics();
		
		model.addAttribute("topics", topics);
		
		return "index";
	}*/
	
	@RequestMapping("/getAllTopics")
	public String getAllTopics(){
		return "new/index";
	}


	@RequestMapping("/index")
	public String index(){
		return "index";
	}

	@RequestMapping("/page2")
	public String page2(){
		return "page2";
	}
	
	@RequestMapping("/getCourses")
	public String getCourses(){
		return "angular/course/getCourses";
	}
	@RequestMapping("/postCourse")
	public String postCourse(){
		return "angular/course/postCourse";
	}
	@RequestMapping("/deleteCourse")
	public String deleteCourse(){
		return "angular/course/deleteCourse";
	}
	@RequestMapping("/updateCourse")
	public String updateCourse(){
		return "angular/course/updateCourse";
	}
	@RequestMapping("/getCourse")
	public String getCourse(){
		return "angular/course/getCourse";
	}
	
	
	@RequestMapping("/getTopics")
	public String pr(){
		return "angular/topic/getTopics";
	}
	@RequestMapping("/postTopic")
	public String pr2(){
		return "angular/topic/postTopic";
	}
	@RequestMapping("/deleteTopic")
	public String pr3(){
		return "angular/topic/deleteTopic";
	}
	
	@RequestMapping("/updateTopic")
	public String pr4(){
		return "angular/topic/updateTopic";
	}
	
	@RequestMapping("/getTopic")
	public String pr5(){
		return "angular/topic/getTopic";
	}
}
