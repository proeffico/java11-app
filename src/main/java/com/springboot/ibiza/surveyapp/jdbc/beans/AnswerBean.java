package com.springboot.ibiza.surveyapp.jdbc.beans;

public class AnswerBean {
    private int answerId;
    private String answer;
	public AnswerBean() {
		super();
	}
	
	public AnswerBean(int answerId, String answer) {
		super();
		this.answerId = answerId;
		this.answer = answer;
	}
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
    
    
}
