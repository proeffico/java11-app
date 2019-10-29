package com.springboot.ibiza.surveyapp.jpa.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "answer")
public class AnswerBean {

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", nullable=false)
	private int aswerId;
	
	@Column(name="answer", nullable=false)
	private String answer;
	
	public AnswerBean() {
		super();
	}

	public AnswerBean(int aswerId, String answer) {
		super();
		this.aswerId = aswerId;
		this.answer = answer;
	}

	public int getAswerId() {
		return aswerId;
	}

	public void setAswerId(int aswerId) {
		this.aswerId = aswerId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
}
