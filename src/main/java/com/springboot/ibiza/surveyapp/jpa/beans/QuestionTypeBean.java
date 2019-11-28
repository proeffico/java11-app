package com.springboot.ibiza.surveyapp.jpa.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="ibiza_question_type")
public class QuestionTypeBean {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="question_type_id", nullable=false)	
    private int questionTypeId;
	
	@Column(name="type", nullable=false)	
    private String type;
	
	@OneToMany(mappedBy = "questionType", cascade=CascadeType.ALL)
	@JsonIgnoreProperties(value = {"questionId","questionary","answers"})
	private List<QuestionBean> questions;

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

	@Override
	public String toString() {
		return "QuestionTypeBean [questionTypeId=" + questionTypeId + ", type=" + type + "]";
	}


}
