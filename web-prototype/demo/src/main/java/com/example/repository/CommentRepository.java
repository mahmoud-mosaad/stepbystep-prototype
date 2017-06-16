package com.example.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Comment;

public interface CommentRepository extends CrudRepository<Comment,Integer> {
	
	public List<Comment> findByGameId(int gameId);

}
