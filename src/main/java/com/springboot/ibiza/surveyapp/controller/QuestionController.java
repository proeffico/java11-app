package com.springboot.ibiza.surveyapp.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.ibiza.surveyapp.jpa.beans.QuestionBean;
import com.springboot.ibiza.surveyapp.repositories.QuestionRepository;


@CrossOrigin( origins = "*" )
@Controller
@RequestMapping("/api/v1/")
public class QuestionController {

	@Autowired
	private QuestionRepository questionRepo;
	
	/* REST API FOR ::QUESTION:: OBJECT */
	@RequestMapping(value="/questions", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<QuestionBean> questionRest() {
		return questionRepo.findAll();
	}
	
	@RequestMapping(value="/questions/question/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Optional<QuestionBean> findQuestionById(@PathVariable("id") String idStr) {
		return questionRepo.findById(Long.parseLong(idStr));
	}
	
	@RequestMapping(value="/questions", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public QuestionBean save(@Valid @RequestBody QuestionBean questionBean) {
		return questionRepo.save(questionBean);
	}
	/*
	@RequestMapping(value="/questions/question/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public QuestionBean update()*/
}
