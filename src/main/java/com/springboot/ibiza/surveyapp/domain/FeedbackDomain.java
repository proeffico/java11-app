package com.springboot.ibiza.surveyapp.domain;

/* This is object, that map answer and question */
public class FeedbackDomain {
	private int feedbackId;
	private AnswerDomain answer;
	private QuestionDomain question;

	public FeedbackDomain() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FeedbackDomain(int feedbackId, AnswerDomain answer, QuestionDomain question) {
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

	public AnswerDomain getAnswer() {
		return answer;
	}

	public void setAnswer(AnswerDomain answer) {
		this.answer = answer;
	}

	public QuestionDomain getQuestion() {
		return question;
	}

	public void setQuestion(QuestionDomain question) {
		this.question = question;
	}

}
