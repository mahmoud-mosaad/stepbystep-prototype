package com.example.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.model.Role;
import com.example.model.Teacher;
import com.example.model.User;
import com.example.repository.RoleRepository;
import com.example.repository.TeacherRepository;

@Service
public class TeacherService {

	@Autowired
	private TeacherRepository teacherRepository;
	
	@Autowired
    private RoleRepository roleRepository;
    
	/*@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	*/
	
	public List<User> getAllStudents(){
		List<User> users = new ArrayList<>();
		teacherRepository.findAll().forEach(users::add);
		return users;
	}

	public User getUser(int id){
		return teacherRepository.findOne(id);
	}
	
	public void addUser(Teacher teacher) {
	//	teacher.setPassword(bCryptPasswordEncoder.encode(teacher.getPassword()));
		teacher.setActive(1);
        Role userRole = roleRepository.findByRole("User");
        teacher.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        teacherRepository.save(teacher);
	}
	
	public void updateUser(Teacher teacher , int id){
		teacherRepository.save(teacher);
	}
	
	public void deleteUser(int id){
		teacherRepository.delete(id);
	}
	
	public User findByEmail(String email){
		return teacherRepository.findByEmail(email);
	}
}
