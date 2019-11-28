package com.springboot.ibiza.surveyapp.service;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.ibiza.surveyapp.controller.QuestionaryController;
import com.springboot.ibiza.surveyapp.jpa.beans.QuestionBean;
import com.springboot.ibiza.surveyapp.jpa.beans.QuestionTypeBean;
import com.springboot.ibiza.surveyapp.jpa.beans.QuestionaryBean;
import com.springboot.ibiza.surveyapp.repositories.QuestionRepository;
import com.springboot.ibiza.surveyapp.repositories.QuestionTypeRepository;

@Service
public class CommonServiceImpl implements CommonService {

	@Autowired
	private QuestionRepository questionRepo;
	
	@Autowired
	private QuestionTypeRepository questionTypeRepo;
	
	Logger logger = Logger.getLogger(CommonServiceImpl.class);
	
	@Override
	public List<QuestionBean> updateQuestionaryParentForQuestionsList(List<QuestionBean> questions, Long questionaryId) {
		questions.forEach(question -> {
			QuestionaryBean questionary = new QuestionaryBean();
			questionary.setQuestionaryId(questionaryId);
			question.setQuestionary(questionary);
			//question.setQuestionType(questionType);
			QuestionTypeBean type = questionTypeRepo.findByQuestionTypeId(question.getQuestionType().getQuestionTypeId());
			question.setQuestionType(type);
			
		});
		return questionRepo.saveAll(questions);
	}
}
