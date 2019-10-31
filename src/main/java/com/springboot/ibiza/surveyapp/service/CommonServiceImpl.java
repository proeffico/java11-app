package com.springboot.ibiza.surveyapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.ibiza.surveyapp.jpa.beans.AnswerBean;
import com.springboot.ibiza.surveyapp.jpa.beans.QuestionBean;
import com.springboot.ibiza.surveyapp.jpa.beans.QuestionaryBean;
import com.springboot.ibiza.surveyapp.repositories.AnswerRepository;
import com.springboot.ibiza.surveyapp.repositories.QuestionRepository;
import com.springboot.ibiza.surveyapp.repositories.QuestionaryRepository;

@Service
public class CommonServiceImpl implements CommonService {

	@Autowired
	private AnswerRepository answerRepo;
	
	@Autowired
	private QuestionRepository questionRepo;
	
	@Autowired
	private QuestionaryRepository questionaryRepo;
	
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AnswerBean createAnswer(AnswerBean answerBean) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public QuestionaryBean findQuestionaryById(Long id) {
		// TODO Auto-generated method stub
		
		return questionaryRepo.findByQuestionaryId(id);
	}

}
