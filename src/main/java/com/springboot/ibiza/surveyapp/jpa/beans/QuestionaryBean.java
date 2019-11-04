package com.springboot.ibiza.surveyapp.jpa.beans;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    private Date createdDate;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="fk_user_id")
	private UserBean user;
	
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = new Date();
	}

	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}
	
	
	
}
