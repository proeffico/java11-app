package com.springboot.ibiza.surveyapp.domainJPA;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Answer {

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int aswerId;
	
	private String answer;
	
	public Answer() {
		super();
	}

	public Answer(int aswerId, String answer) {
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
