package com.example.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.model.Role;
import com.example.model.Student;
import com.example.model.User;
import com.example.repository.RoleRepository;
import com.example.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
    private RoleRepository roleRepository;
    
	/*@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	*/
	
	public List<User> getAllStudents(){
		List<User> users = new ArrayList<>();
		studentRepository.findAll().forEach(users::add);
		return users;
	}

	public User getUser(int id){
		return studentRepository.findOne(id);
	}
	
	public void addUser(Student student) {
	//	student.setPassword(bCryptPasswordEncoder.encode(student.getPassword()));
		student.setActive(1);
        Role userRole = roleRepository.findByRole("User");
        student.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        studentRepository.save(student);
	}
	
	public void updateUser(Student student , int id){
		studentRepository.save(student);
	}
	
	public void deleteUser(int id){
		studentRepository.delete(id);
	}
	
	public User findByEmail(String email){
		return studentRepository.findByEmail(email);
	}
}
