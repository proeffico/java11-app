package com.springboot.ibiza.surveyapp.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.ibiza.surveyapp.jpa.beans.QuestionaryBean;

@Repository
public interface QuestionaryRepository extends CrudRepository<QuestionaryBean, Long>{
	
    List<QuestionaryBean> findAll();
    QuestionaryBean save(QuestionaryBean questionary);
    QuestionaryBean findByQuestionaryId(Long id);
    
}
