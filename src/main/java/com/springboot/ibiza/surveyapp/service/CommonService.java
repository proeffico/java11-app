package com.springboot.ibiza.surveyapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.ibiza.surveyapp.jpa.beans.QuestionBean;

@Service
public interface CommonService {
	public List<QuestionBean> updateQuestionaryParentForQuestionsList(List<QuestionBean> questions, Long questionaryId);
}
