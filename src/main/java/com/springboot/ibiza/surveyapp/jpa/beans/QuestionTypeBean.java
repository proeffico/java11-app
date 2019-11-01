package com.springboot.ibiza.surveyapp.jpa.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="question_type")
public class QuestionTypeBean {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="question_type_id", nullable=false)	
    private int questionTypeId;
	
	@Column(name="type", nullable=false)	
    private String type;
	
	@OneToMany
	@JoinColumn(name="fk_question_type_id")
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
