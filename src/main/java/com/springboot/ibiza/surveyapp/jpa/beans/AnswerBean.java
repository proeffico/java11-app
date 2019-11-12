package com.springboot.ibiza.surveyapp.jpa.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ibiza_answer")
public class AnswerBean {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="answer_id", nullable=false)
	private int aswerId;
	
	@ManyToOne
	@JsonIgnoreProperties(value = {"questionary", "questionType"})
	@JoinColumn(name="fk_question_id")
	private QuestionBean question;
	
	@ManyToOne
	@JsonIgnoreProperties(value = {"answerOptionId"})
	@JoinColumn(name="fk_answer_option_id")
	private AnswerOptionBean answerOption;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "answered_date", nullable = false, updatable = false)
    @CreatedDate
    private Date answeredDate;
	
	public int getAswerId() {
		return aswerId;
	}

	public void setAswerId(int aswerId) {
		this.aswerId = aswerId;
	}

	public QuestionBean getQuestion() {
		return question;
	}

	public void setQuestion(QuestionBean question) {
		this.question = question;
	}

	public AnswerOptionBean getAnswerOption() {
		return answerOption;
	}

	public void setAnswerOption(AnswerOptionBean answerOption) {
		this.answerOption = answerOption;
	}

	public Date getAnsweredDate() {
		return answeredDate;
	}

	public void setAnsweredDate(Date answeredDate) {
		this.answeredDate = answeredDate;
	}
	
	
}
