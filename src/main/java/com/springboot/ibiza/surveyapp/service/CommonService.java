package com.springboot.ibiza.surveyapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.ibiza.surveyapp.jpa.beans.QuestionBean;

@Service
public interface CommonService {
<<<<<<< HEAD
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
=======
	public List<QuestionBean> updateQuestionaryParentForQuestionsList(List<QuestionBean> questions, Long questionaryId);
>>>>>>> ebc62eb48ac8c52ce7992cfd50ba6d8c5ef02f15
}
