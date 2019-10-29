package com.springboot.ibiza.surveyapp.service;

import java.util.List;

import com.springboot.ibiza.surveyapp.jpa.beans.AnswerBean;
import com.springboot.ibiza.surveyapp.jpa.beans.QuestionBean;
import com.springboot.ibiza.surveyapp.jpa.beans.QuestionaryBean;

public interface CommonService {
   public List<AnswerBean> findAllAnswers();
   public List<QuestionBean> findAllQuestions();
   public List<QuestionaryBean> findAllQuestionaries();
   public QuestionaryBean createQuestionary(QuestionaryBean questionaryBean);
   public QuestionBean createQuestion(QuestionBean questionBean);
   public AnswerBean createAnswer(AnswerBean answerBean);
}
