package com.springboot.ibiza.surveyapp.jpa.beans;


public class AnswerJsonBean {
	
	private Long questionId;
	
	
	
	private String answerStr;

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	

	public String getAnswerStr() {
		return answerStr;
	}

	public void setAnswerStr(String answerStr) {
		this.answerStr = answerStr;
	}
	
	
	

}
