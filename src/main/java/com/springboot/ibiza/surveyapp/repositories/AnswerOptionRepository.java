package com.springboot.ibiza.surveyapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.ibiza.surveyapp.jpa.beans.AnswerOptionBean;
import com.springboot.ibiza.surveyapp.jpa.beans.QuestionaryBean;

public interface AnswerOptionRepository extends JpaRepository<AnswerOptionBean, Long> {
    AnswerOptionBean findByAnswerOptionId(Long answerOptionId);

}
