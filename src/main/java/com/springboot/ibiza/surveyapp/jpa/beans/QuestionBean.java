package com.springboot.ibiza.surveyapp.jpa.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ibiza_question")
public class QuestionBean {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="question_id")
	private Long questionId;
	
	@Column(name="question")
	private String question;
		
	/*
	 * FetchType.LAZY does not get related questionary when finding question
	 * FetchType.EAGER get all related questionary when finding question
	 * use @JsonIgnore to prevent to take this data to JSON object
	 * can use @JsonIgnoreProperties and @JsonIgnoreType to filter which data will be present in JSON object as well
	 * be careful to use mappedBy inside OneToMany in multiple entities, because it could give the error Infinite Recursion with Jackson JSON and Hibernate JPA issue
	 */
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="fk_questionary_id")
	private QuestionaryBean questionary;
	
	@ManyToOne
	@JoinColumn( name="fk_question_type_id")
	private QuestionTypeBean questionType;
	
	public QuestionBean() {
		super();
	}

	public QuestionBean(Long questionId, String question) {
		super();
		this.questionId = questionId;
		this.question = question;
	}

	public QuestionBean(Long questionId, String question, QuestionaryBean questionary, QuestionTypeBean questionType) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.questionary = questionary;
		this.questionType = questionType;
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


	public QuestionaryBean getQuestionary() {
		return questionary;
	}

	public void setQuestionary(QuestionaryBean questionary) {
		this.questionary = questionary;
	}

	public QuestionTypeBean getQuestionType() {
		return questionType;
	}

	public void setQuestionType(QuestionTypeBean questionType) {
		this.questionType = questionType;
	}
	
}
