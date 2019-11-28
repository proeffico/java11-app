package com.springboot.ibiza.surveyapp.jpa.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ibiza_question")
public class QuestionBean {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="question_id")
	private Long questionId;
	
	@Column(name="question")
	private String question;
	
	@ManyToOne
	@JsonIgnoreProperties(value = {"questions", "user"}, allowSetters=true)
	@JoinColumn(name="fk_questionary_id")
	private QuestionaryBean questionary;
	
	@ManyToOne
	@JsonIgnoreProperties(value={"questions", "questionTypeId"}, allowSetters=true)
	@JoinColumn(name="fk_question_type_id")
	private QuestionTypeBean questionType;
	


	@OneToMany(mappedBy="question", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<AnswerBean> answers;
	
	@OneToMany(mappedBy="question", cascade = CascadeType.ALL)
	@JsonIgnoreProperties(value= {"answers", "questions"})
	private List<AnswerOptionBean> answerOptions;
	
	public Long getQuestionId() {
		return questionId;
	}

	public List<AnswerOptionBean> getAnswerOptions() {
		return answerOptions;
	}

	public void setAnswerOptions(List<AnswerOptionBean> answerOptions) {
		this.answerOptions = answerOptions;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}


	public QuestionaryBean getQuestionary() {
		return questionary;
	}

	public void setQuestionary(QuestionaryBean questionary) {
		this.questionary = questionary;
	}

	public QuestionTypeBean getQuestionType() {
		return questionType;
	}

	public void setQuestionType(QuestionTypeBean questionType) {
		this.questionType = questionType;
	}

	public List<AnswerBean> getAnswers() {
		return answers;
	}

	public void setAnswers(List<AnswerBean> answers) {
		this.answers = answers;
	}
	@Override
	public String toString() {
		return "QuestionBean [questionId=" + questionId + ", question=" + question + ", questionary=" + questionary
				+ ", questionType=" + questionType + "]";
	}
	
	
	
}
