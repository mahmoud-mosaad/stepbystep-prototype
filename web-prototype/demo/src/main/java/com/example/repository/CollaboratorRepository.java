package com.example.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Collaborator;

public interface CollaboratorRepository extends CrudRepository<Collaborator,Integer>{

	public List<Collaborator> findByGameId(int gameId);

}
