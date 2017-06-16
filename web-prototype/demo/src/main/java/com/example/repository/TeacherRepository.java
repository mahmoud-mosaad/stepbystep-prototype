package com.example.repository;

import javax.transaction.Transactional;

import com.example.model.Teacher;

@Transactional
public interface TeacherRepository extends UserBaseRepository<Teacher>{
	Teacher findByEmail(String email);
}
