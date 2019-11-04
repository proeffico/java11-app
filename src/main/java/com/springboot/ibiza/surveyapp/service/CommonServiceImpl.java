package com.springboot.ibiza.surveyapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.ibiza.surveyapp.jpa.beans.AnswerBean;
import com.springboot.ibiza.surveyapp.jpa.beans.QuestionBean;
import com.springboot.ibiza.surveyapp.jpa.beans.QuestionTypeBean;
import com.springboot.ibiza.surveyapp.jpa.beans.QuestionaryBean;
import com.springboot.ibiza.surveyapp.jpa.beans.UserBean;
import com.springboot.ibiza.surveyapp.repositories.AnswerRepository;
import com.springboot.ibiza.surveyapp.repositories.QuestionRepository;
import com.springboot.ibiza.surveyapp.repositories.QuestionTypeRepository;
import com.springboot.ibiza.surveyapp.repositories.QuestionaryRepository;
import com.springboot.ibiza.surveyapp.repositories.UserRepository;

@Service
public class CommonServiceImpl implements CommonService {

	@Autowired
	private AnswerRepository answerRepo;
	
	@Autowired
	private QuestionRepository questionRepo;
	
	@Autowired
	private QuestionaryRepository questionaryRepo;
	
	@Autowired
	private QuestionTypeRepository questionTypeRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public List<AnswerBean> findAllAnswers() {
		return answerRepo.findAll();
	}

	@Override
	public List<QuestionBean> findAllQuestions() {
		return questionRepo.findAll();
	}

	@Override
	public List<QuestionaryBean> findAllQuestionaries() {
		return questionaryRepo.findAll();
	}

	@Override
	public QuestionaryBean createQuestionary(QuestionaryBean questionaryBean) {
		return questionaryRepo.save(questionaryBean);
	}

	@Override
	public QuestionBean createQuestion(QuestionBean questionBean) {
		return questionRepo.save(questionBean);
	}

	@Override
	public AnswerBean createAnswer(AnswerBean answerBean) {
		return null;
	}

	public QuestionaryBean findQuestionaryById(Long id) {
		return (questionaryRepo.findByQuestionaryId(id) != null)? questionaryRepo.findByQuestionaryId(id) : new QuestionaryBean();
	}

	@Override
	public List<QuestionTypeBean> findAllQuestionTypes() {
		return questionTypeRepo.findAll();
	}

	@Override
	public UserBean createUser(UserBean user) {
		return userRepo.save(user);
	}

}
