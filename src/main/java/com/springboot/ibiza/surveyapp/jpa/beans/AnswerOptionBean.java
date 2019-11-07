package com.springboot.ibiza.surveyapp.jpa.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="ibiza_answer_option")
public class AnswerOptionBean {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="answer_option_id")
    private int answerOptionId;
	
	@Column(name="answer_option")
	private String answerOption;
	
	@OneToMany(mappedBy = "answerOption", cascade = CascadeType.ALL)
	@JsonIgnoreProperties(value = {"aswerId","question","answerOption","answeredDate"})
	private List<AnswerBean> answers;

	public int getAnswerOptionId() {
		return answerOptionId;
	}

	public void setAnswerOptionId(int answerOptionId) {
		this.answerOptionId = answerOptionId;
	}

	public String getAnswerOption() {
		return answerOption;
	}

	public void setAnswerOption(String answerOption) {
		this.answerOption = answerOption;
	}

	public List<AnswerBean> getAnswers() {
		return answers;
	}

	public void setAnswers(List<AnswerBean> answers) {
		this.answers = answers;
	}
	
	
}
