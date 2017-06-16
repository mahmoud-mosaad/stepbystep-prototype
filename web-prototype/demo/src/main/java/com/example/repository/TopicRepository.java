package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Topic;

public interface TopicRepository extends CrudRepository<Topic,Integer> {
	
}
