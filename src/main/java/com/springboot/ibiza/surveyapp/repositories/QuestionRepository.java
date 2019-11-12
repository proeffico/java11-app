package com.springboot.ibiza.surveyapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.ibiza.surveyapp.jpa.beans.QuestionBean;

@Repository
public interface QuestionRepository extends JpaRepository<QuestionBean, Long> {
<<<<<<< HEAD
    List<QuestionBean> findAll();
    QuestionBean findByQuestionId(Long id);
=======

>>>>>>> ebc62eb48ac8c52ce7992cfd50ba6d8c5ef02f15
}
