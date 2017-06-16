package com.example.repository;

import javax.transaction.Transactional;

import com.example.model.User;

@Transactional
public interface UserRepository extends UserBaseRepository<User>{

	User findByEmail(String email);
	
}
