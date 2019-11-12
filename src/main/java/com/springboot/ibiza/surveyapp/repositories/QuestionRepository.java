package com.springboot.ibiza.surveyapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.ibiza.surveyapp.jpa.beans.QuestionBean;

@Repository
public interface QuestionRepository extends JpaRepository<QuestionBean, Long> {
    List<QuestionBean> findAll();
    QuestionBean findByQuestionId(Long id);
}
