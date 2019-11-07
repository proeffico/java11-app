package com.springboot.ibiza.surveyapp.service;

import java.util.List;

import com.springboot.ibiza.surveyapp.jpa.beans.AnswerBean;
import com.springboot.ibiza.surveyapp.jpa.beans.QuestionBean;
import com.springboot.ibiza.surveyapp.jpa.beans.QuestionTypeBean;
import com.springboot.ibiza.surveyapp.jpa.beans.QuestionaryBean;
import com.springboot.ibiza.surveyapp.jpa.beans.UserBean;

public interface CommonService {
   public List<AnswerBean> findAllAnswers();
   public List<QuestionBean> findAllQuestions();
   public List<QuestionaryBean> findAllQuestionaries();
   public List<QuestionTypeBean> findAllQuestionTypes();
   
   public QuestionaryBean createQuestionary(QuestionaryBean questionaryBean);
   public QuestionBean createQuestion(QuestionBean questionBean);
   public AnswerBean createAnswer(AnswerBean answerBean);
   public QuestionaryBean findQuestionaryById(Long id);
   public UserBean createUser(UserBean user);
   
   public List<QuestionBean> updateQuestionaryParentForQuestionsList(List<QuestionBean> questions, Long questionaryId);
}
