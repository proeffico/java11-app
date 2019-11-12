package com.springboot.ibiza.surveyapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.ibiza.surveyapp.jpa.beans.AnswerBean;
import com.springboot.ibiza.surveyapp.repositories.AnswerRepository;

@CrossOrigin( origins = "*" )
@Controller
@RequestMapping("/api/v1/")
public class AnswerController {
	Logger logger = Logger.getLogger(AnswerController.class);

	@Autowired
	private AnswerRepository answerRepo;
	
	/* REST API FOR ::ANSWER:: OBJECT */
	@RequestMapping(value = "answers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<AnswerBean> findAllAnswers(){
		return answerRepo.findAll();
	}
	
	@RequestMapping(value="/answer", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public AnswerBean save(@Valid @RequestBody AnswerBean answer) {
		return answerRepo.save(answer);
	}
	
	@RequestMapping(value="/answers", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AnswerBean> saveAll(@Valid @RequestBody List<AnswerBean> answers) {
		return answerRepo.saveAll(answers);
	}
}
