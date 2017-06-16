package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class SingleQuestionSingleAnswer extends Question{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int id;
	
	private String content;
	private String answer1;
	private String answer2;
	
	@OneToOne
	private Question question;
	
	public SingleQuestionSingleAnswer(){
		
	}

	public SingleQuestionSingleAnswer(int id, String content, String answer1, String answer2, Question question) {
		super();
		this.id = id;
		this.content = content;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.question = question;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAnswer1() {
		return answer1;
	}

	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}

	public String getAnswer2() {
		return answer2;
	}

	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	
}
