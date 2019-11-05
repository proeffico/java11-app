package com.springboot.ibiza.surveyapp.jpa.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="ibiza_question_type")
public class QuestionTypeBean {
	/*
	 * GenerationType.AUTO - that simply lets an implementation choose what it wants to use.
	 * GenerationType.IDENTITY - (as per JPA javadocs and spec - what you should be referring to) means autoincrement. 
	 * There is no such concept in Oracle, yet there is in MySQL, SQLServer and a few others. I would expect 
	 * any decent JPA implementation to flag an error when even trying such a thing.
	 */
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="question_type_id", nullable=false)	
    private int questionTypeId;
	
	@Column(name="type", nullable=false)	
    private String type;
	
	@JsonIgnore
	@OneToMany
	private List<QuestionBean> questions;

	public QuestionTypeBean() {
		super();
	}


	public QuestionTypeBean(int questionTypeId, String type) {
		super();
		this.questionTypeId = questionTypeId;
		this.type = type;
	}


	public int getQuestionTypeId() {
		return questionTypeId;
	}


	public void setQuestionTypeId(int questionTypeId) {
		this.questionTypeId = questionTypeId;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public List<QuestionBean> getQuestions() {
		return questions;
	}


	public void setQuestions(List<QuestionBean> questions) {
		this.questions = questions;
	}
	
	
}
