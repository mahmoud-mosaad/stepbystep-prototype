package com.example.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.model.GameChange;

public interface GameChangeRepository extends CrudRepository<GameChange,Integer>{

	public List<GameChange> findByGameId(int gameId);

}
