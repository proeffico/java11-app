package com.springboot.ibiza.surveyapp.controller;

import java.util.ArrayList;
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
import com.springboot.ibiza.surveyapp.jpa.beans.AnswerJsonBean;
import com.springboot.ibiza.surveyapp.jpa.beans.QuestionBean;
import com.springboot.ibiza.surveyapp.repositories.AnswerRepository;
import com.springboot.ibiza.surveyapp.repositories.QuestionRepository;
import com.springboot.ibiza.surveyapp.service.CommonService;

@CrossOrigin( origins = "*" )
@Controller
@RequestMapping("/api/v1/")
public class AnswerController {
	Logger logger = Logger.getLogger(AnswerController.class);

	@Autowired
	private CommonService service;
	@Autowired
	private QuestionRepository questionRepo;
	@Autowired
	private AnswerRepository answerRepo;
	/* REST API FOR ::ANSWER:: OBJECT */
	@RequestMapping(value = "answers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<AnswerBean> findAllAnswers(){
		return service.findAllAnswers();
	}
	
	@RequestMapping(value="/answers", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<AnswerBean> save(@Valid @RequestBody List<AnswerJsonBean> answersJson) {
		List<AnswerBean> answers = new ArrayList<AnswerBean>();
		
		answersJson.forEach(answerObj -> {
			AnswerBean answer = new AnswerBean();
		
		
			QuestionBean question = questionRepo.findByQuestionId(answerObj.getQuestionId());
			answer.setQuestion(question);
			answer.setAnswerStr(answerObj.getAnswerStr());
			answers.add(answer);
		});
		
		return answerRepo.saveAll(answers);
	}
	
	/*@RequestMapping(value="/answer", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public AnswerBean save(@Valid @RequestBody AnswerBean answerBean) {
		AnswerBean answerBean = new AnswerBean();
		return service.createAnswer(answerBean);
	}*/
}
