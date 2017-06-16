package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.custom.Function;
import com.example.model.User;
import com.example.service.RoleService;
import com.example.service.StudentService;
import com.example.service.TeacherService;
import com.example.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/default")
	public String redirectAfterDefault(HttpServletRequest request,HttpServletResponse response){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String role = auth.getAuthorities().toString();
		String roles []  = role.substring(1, role.length()-1).split(",");
		Function f = new Function();
		if (f.contains(roles,"ADMIN") == true){
			return "redirect:/admin/home";
		}
		else if (f.contains(roles,"TEACHER") == true){
			return "redirect:/teacher/home";
		}
	    return "redirect:/student/home";
	}

	@RequestMapping(value={"/"}, method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request,HttpServletResponse response){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		ModelAndView modelAndView = new ModelAndView();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			String page = redirectAfterDefault(request,response);
			modelAndView.setViewName(page);
		}
		else
			modelAndView.setViewName("home");
		return modelAndView;
	}
	
	@RequestMapping(value={"/login"}, method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		ModelAndView modelAndView = new ModelAndView();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			String page = redirectAfterDefault(request,response);
			modelAndView.setViewName(page);
		}
		else
			modelAndView.setViewName("login");
		return modelAndView;
	}
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public ModelAndView registration(HttpServletRequest request,HttpServletResponse response){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		ModelAndView modelAndView = new ModelAndView();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			String page = redirectAfterDefault(request,response);
			modelAndView.setViewName(page);
		}
		else{
			User user = new User();
			modelAndView.addObject("user", user);
			modelAndView.setViewName("register");
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
		
		ModelAndView modelAndView = new ModelAndView();
		User userExists = userService.findByEmail(user.getEmail());
		if (userExists != null) {
			bindingResult
					.rejectValue("email", "error.user",
							"There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("register");
		} else {
			userService.addUser(user,user.getType());
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject(user.getType(), new User());
			modelAndView.setViewName("register");
		}
		return modelAndView;
	}
	
	@RequestMapping(value="/admin/home", method = RequestMethod.GET)
	public ModelAndView adminHome(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByEmail(auth.getName());
		modelAndView.addObject("userName", "Welcome " + user.getUserName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
		modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
		modelAndView.setViewName("admin-home");
		return modelAndView;
	}

	@RequestMapping(value="/student/home", method = RequestMethod.GET)
	public ModelAndView studentHome(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByEmail(auth.getName());
		modelAndView.addObject("userName", "Welcome " + user.getUserName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
		modelAndView.addObject("studentMessage","Content Available Only for Users with Student Role");
		modelAndView.setViewName("student-home");
		return modelAndView;
	}
	
	@RequestMapping(value="/teacher/home", method = RequestMethod.GET)
	public ModelAndView teacherHome(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByEmail(auth.getName());
		modelAndView.addObject("userName", "Welcome " + user.getUserName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
		modelAndView.addObject("teacherMessage","Content Available Only for Users with Teacher Role");
		modelAndView.setViewName("teacher-home");
		return modelAndView;
	}
	
}