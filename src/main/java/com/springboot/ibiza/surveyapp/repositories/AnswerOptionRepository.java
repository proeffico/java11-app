package com.springboot.ibiza.surveyapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.ibiza.surveyapp.jpa.beans.AnswerOptionBean;

public interface AnswerOptionRepository extends JpaRepository<AnswerOptionBean, Long> {

}
