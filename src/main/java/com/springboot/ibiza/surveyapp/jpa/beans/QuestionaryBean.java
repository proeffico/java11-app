package com.springboot.ibiza.surveyapp.jpa.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "questionary")
public class QuestionaryBean {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="questionary_id")
	private Long questionaryId;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name="fk_questionary_id")
	private List<QuestionBean> questions;
	
/*	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    @CreatedDate
    private Date createdAt; */
	
	public QuestionaryBean() {
		super();
	}

	public QuestionaryBean(Long questionaryId, String name) {
		super();
		this.questionaryId = questionaryId;
		this.name = name;
	}

	public Long getQuestionaryId() {
		return questionaryId;
	}

	public void setQuestionaryId(Long questionaryId) {
		this.questionaryId = questionaryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<QuestionBean> getQuestions() {
		return questions;
	}

	public void setQuestions(List<QuestionBean> questions) {
		this.questions = questions;
	}


	
}
