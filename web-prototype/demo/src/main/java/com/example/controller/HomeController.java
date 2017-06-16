package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.TopicService;

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
	

	@RequestMapping("/index")
	public String index(){
		return "index";
	}

	@RequestMapping("/page2")
	public String page2(){
		return "page2";
	}	


	@RequestMapping("/createGame")
	public String createGame(){
		return "createGame";
	}	

	@RequestMapping("/playGame")
	public String playGame(){
		return "playGame";
	}	
	

	@RequestMapping("/getQuestions")
	public String getQuestions(){
		return "question/getQuestions";
	}
	
	@RequestMapping("/postQuestion")
	public String postQuestion(){
		return "question/postQuestion";
	}
	@RequestMapping("/deleteQuestion")
	public String deleteQuestion(){
		return "question/deleteQuestion";
	}
	@RequestMapping("/updateQuestion")
	public String updateQuestion(){
		return "question/updateQuestion";
	}
	@RequestMapping("/getQuestion")
	public String getQuestion(){
		return "question/getQuestion";
	}
	
	

	@RequestMapping("/getGames")
	public String getGames(){
		return "game/getGames";
	}
	
	@RequestMapping("/postGame")
	public String postGame(){
		return "game/postGame";
	}
	@RequestMapping("/deleteGame")
	public String deleteGame(){
		return "game/deleteGame";
	}
	@RequestMapping("/updateGame")
	public String updateGame(){
		return "game/updateGame";
	}
	@RequestMapping("/getGame")
	public String getGame(){
		return "game/getGame";
	}
	
	@RequestMapping("/getLessons")
	public String getLessons(){
		return "lesson/getLessons";
	}
	
	@RequestMapping("/postLesson")
	public String postLesson(){
		return "lesson/postLesson";
	}
	@RequestMapping("/deleteLesson")
	public String deleteLesson(){
		return "lesson/deleteLesson";
	}
	@RequestMapping("/updateLesson")
	public String updateLesson(){
		return "lesson/updateLesson";
	}
	@RequestMapping("/getLesson")
	public String getLesson(){
		return "lesson/getLesson";
	}
	
	
	
	@RequestMapping("/getAllCourses")
	public String getAllCourses(){
		return "course/getAllCourses";
	}
	
	
	@RequestMapping("/getCourses")
	public String getCourses(){
		return "course/getCourses";
	}
	
	@RequestMapping("/postCourse")
	public String postCourse(){
		return "course/postCourse";
	}
	@RequestMapping("/deleteCourse")
	public String deleteCourse(){
		return "course/deleteCourse";
	}
	@RequestMapping("/updateCourse")
	public String updateCourse(){
		return "course/updateCourse";
	}
	@RequestMapping("/getCourse")
	public String getCourse(){
		return "course/getCourse";
	}
	
	
	@RequestMapping("/getTopics")
	public String pr(){
		return "topic/getTopics";
	}
	@RequestMapping("/postTopic")
	public String pr2(){
		return "topic/postTopic";
	}
	@RequestMapping("/deleteTopic")
	public String pr3(){
		return "topic/deleteTopic";
	}
	
	@RequestMapping("/updateTopic")
	public String pr4(){
		return "topic/updateTopic";
	}
	
	@RequestMapping("/getTopic")
	public String pr5(){
		return "topic/getTopic";
	}
}
