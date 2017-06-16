package com.example.repository;

import javax.transaction.Transactional;

import com.example.model.Student;

@Transactional
public interface StudentRepository extends UserBaseRepository<Student>{
	Student findByEmail(String email);
}
