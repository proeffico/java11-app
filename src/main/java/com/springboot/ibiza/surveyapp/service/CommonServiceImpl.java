package com.springboot.ibiza.surveyapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springboot.ibiza.surveyapp.jpa.beans.QuestionBean;
import com.springboot.ibiza.surveyapp.jpa.beans.QuestionaryBean;
import com.springboot.ibiza.surveyapp.repositories.QuestionRepository;

public class CommonServiceImpl implements CommonService {

	@Autowired
	private QuestionRepository questionRepo;
	
	@Override
	public List<QuestionBean> updateQuestionaryParentForQuestionsList(List<QuestionBean> questions, Long questionaryId) {
		questions.forEach(question -> {
			QuestionaryBean questionary = new QuestionaryBean();
			questionary.setQuestionaryId(questionaryId);
			question.setQuestionary(questionary);
		});
		return questionRepo.saveAll(questions);
	}
}
