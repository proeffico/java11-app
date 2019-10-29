package com.springboot.ibiza.surveyapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.ibiza.surveyapp.dao.answerDAO.AnswerDao;
import com.springboot.ibiza.surveyapp.domain.AnswerDomain;

@Controller
@RequestMapping("/api/v1/")
public class RestController {
    
	@Autowired
	private AnswerDao answerDao;
	
	@RequestMapping(value = "answers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<AnswerDomain> findAllAnswers(){
		return answerDao.findAllAnswers();
	}
}
