package com.springboot.ibiza.surveyapp.jpa.beans;


public class AnswerJsonBean {
	
	private Long questionId;
	
	private Long answerOptionId;
	
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

	public Long getAnswerOptionId() {
		return answerOptionId;
	}

	public void setAnswerOptionId(Long answerOptionId) {
		this.answerOptionId = answerOptionId;
	}
	
	
	

}
