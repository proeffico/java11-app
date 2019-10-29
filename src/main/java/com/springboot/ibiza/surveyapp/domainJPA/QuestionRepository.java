package com.springboot.ibiza.surveyapp.domainJPA;

import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Long> {
	

}
