package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Comment;
import com.example.repository.CommentRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepository;
	

	public List<Comment> getAllComments(int gameId){
		List<Comment> comments = 
				commentRepository.findByGameId(gameId);
		return comments;
	}
	
	
	public Comment getComment(int commentId){
		return commentRepository.findOne(commentId);
	}
	
	public void addComment(Comment comment){
		commentRepository.save(comment);
	}
	
	public void updateComment(Comment comment){
		commentRepository.save(comment);
	}

	public void deleteComment(int commentId){
		commentRepository.delete(commentId);
	}
	
}
