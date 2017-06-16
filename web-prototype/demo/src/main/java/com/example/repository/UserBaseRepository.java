package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.example.model.User;

@NoRepositoryBean
public interface UserBaseRepository <T extends User> 
extends CrudRepository<T, Integer> {

	//public T findByEmail(String email);
	//  @Query("select u from #{#entityName} as u where u.email = ?1 ")
	//  T findByEmail(String email);
}
