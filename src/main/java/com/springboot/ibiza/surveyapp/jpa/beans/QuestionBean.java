package com.springboot.ibiza.surveyapp.jpa.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "question")
public class QuestionBean {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="question_id")
	private Long questionId;
	
	@Column(name="question")
	private String question;
	
	/*
	 * FetchType.LAZY does not get related questionary when finding question
	 * FetchType.EAGER get all related questionary when finding question
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnore
	@JoinColumn(name="fk_question_id")
	private QuestionaryBean questionaryBean;
	
	public QuestionBean() {
		super();
	}

	public QuestionBean(Long questionId, String question) {
		super();
		this.questionId = questionId;
		this.question = question;
	}
	

	public QuestionBean(Long questionId, String question, QuestionaryBean questionaryBean) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.questionaryBean = questionaryBean;
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

	public QuestionaryBean getQuestionaryBean() {
		return questionaryBean;
	}

	public void setQuestionaryBean(QuestionaryBean questionaryBean) {
		this.questionaryBean = questionaryBean;
	}
	
	
}
