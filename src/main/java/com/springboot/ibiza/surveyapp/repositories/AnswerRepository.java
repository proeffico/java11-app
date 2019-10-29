package com.springboot.ibiza.surveyapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.ibiza.surveyapp.jpa.beans.AnswerBean;

@Repository
public interface AnswerRepository extends JpaRepository<AnswerBean, Integer> {
    List<AnswerBean> findAll();
}
