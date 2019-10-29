package com.springboot.ibiza.surveyapp.dao.answerDAO;

import java.util.List;

import org.springframework.stereotype.Component;

import com.springboot.ibiza.surveyapp.domain.AnswerDomain;

@Component
public interface AnswerDao {
	public boolean isAnswerExist(AnswerDomain answer);
    public int insertNewAnswer(List<AnswerDomain> answers);
    public List<AnswerDomain> findAllAnswers();
}
