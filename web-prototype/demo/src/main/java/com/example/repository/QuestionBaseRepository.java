package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.example.model.Question;

@NoRepositoryBean
public interface QuestionBaseRepository <T extends Question> 
extends CrudRepository<T, Integer>  {

}
