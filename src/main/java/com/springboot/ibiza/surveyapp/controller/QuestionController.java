package com.springboot.ibiza.surveyapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.ibiza.surveyapp.jpa.beans.QuestionBean;
import com.springboot.ibiza.surveyapp.service.CommonService;

@CrossOrigin( origins = "*" )
@Controller
@RequestMapping("/api/v1/")
public class QuestionController {

	@Autowired
	private CommonService service;
	
	/* REST API FOR ::QUESTION:: OBJECT */
	@RequestMapping(value="/questions", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<QuestionBean> questionRest() {
		return service.findAllQuestions();
	}
	
	@RequestMapping(value="/questions", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public QuestionBean save(@Valid @RequestBody QuestionBean questionBean) {
		return service.createQuestion(questionBean);
	}
}
