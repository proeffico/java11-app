package com.springboot.ibiza.surveyapp.domainJPA;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Questionary {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long questionaryId;
	
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "questionary")
	private List<Question> questions;
	public Questionary() {
		super();
	}

	public Questionary(Long questionaryId, String name) {
		super();
		this.questionaryId = questionaryId;
		this.name = name;
	}

	public Long getQuestionaryId() {
		return questionaryId;
	}

	public void setQuestionaryId(Long questionaryId) {
		this.questionaryId = questionaryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
}
