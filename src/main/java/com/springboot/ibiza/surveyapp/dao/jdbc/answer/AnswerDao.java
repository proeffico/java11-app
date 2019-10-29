package com.springboot.ibiza.surveyapp.dao.jdbc.answer;

import java.util.List;

import org.springframework.stereotype.Component;

import com.springboot.ibiza.surveyapp.jdbc.beans.AnswerBean;

@Component
public interface AnswerDao {
	public boolean isAnswerExist(AnswerBean answer);
    public int insertNewAnswer(List<AnswerBean> answers);
    public List<AnswerBean> findAllAnswers();
}
