package com.springboot.ibiza.surveyapp.domainJPA;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long questionId;
	
	private String question;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="questionaryId")
	private Questionary questionary;
	
	public Question() {
		super();
	}

	public Question(Long questionId, String question) {
		super();
		this.questionId = questionId;
		this.question = question;
	}
	

	public Question(Long questionId, String question, Questionary questionary) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.questionary = questionary;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	
}
