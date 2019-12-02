package com.springboot.ibiza.surveyapp.jpa.beans;

import java.util.List;
import java.util.Set;

public class AnswerJsonBean {
	
	private Long questionId;
	
	private List<AnswerOptionBean> answerOptions;
	
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

	public List<AnswerOptionBean> getAnswerOptions() {
		return answerOptions;
	}

	public void setAnswerOptions(List<AnswerOptionBean> answerOptions) {
		this.answerOptions = answerOptions;
	}

	
	
	

}
