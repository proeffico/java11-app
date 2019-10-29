package com.springboot.ibiza.surveyapp.jdbc.beans;

/* This is object, that map answer and question */
public class FeedbackBean {
	private int feedbackId;
	private AnswerBean answer;
	private QuestionBean question;

	public FeedbackBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FeedbackBean(int feedbackId, AnswerBean answer, QuestionBean question) {
		super();
		this.feedbackId = feedbackId;
		this.answer = answer;
		this.question = question;
	}

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public AnswerBean getAnswer() {
		return answer;
	}

	public void setAnswer(AnswerBean answer) {
		this.answer = answer;
	}

	public QuestionBean getQuestion() {
		return question;
	}

	public void setQuestion(QuestionBean question) {
		this.question = question;
	}

}
