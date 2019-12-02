
package com.springboot.ibiza.surveyapp.jpa.beans;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="ibiza_answer_option")
public class AnswerOptionBean {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="answer_option_id")
    private Long answerOptionId;
	
	@Column(name="answer_option")
	private String answerOption;
	
	/*@OneToMany(mappedBy = "answerOption", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<AnswerBean> answers;*/
	@ManyToMany(mappedBy = "chosenAnswers")
	List<AnswerBean> answers;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="fk_question_id")
	private QuestionBean question;
	
	public QuestionBean getQuestion() {
		return question;
	}

	public void setQuestion(QuestionBean question) {
		this.question = question;
	}

	public Long getAnswerOptionId() {
		return answerOptionId;
	}
	
	public void setAnswerOptionId(Long answerOptionId) {
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
