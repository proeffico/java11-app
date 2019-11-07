package com.springboot.ibiza.surveyapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.ibiza.surveyapp.jpa.beans.QuestionaryBean;

@Repository
public interface QuestionaryRepository extends JpaRepository<QuestionaryBean, Long>{
    List<QuestionaryBean> findAll();
    QuestionaryBean findByQuestionaryId(Long questionaryId);
}
