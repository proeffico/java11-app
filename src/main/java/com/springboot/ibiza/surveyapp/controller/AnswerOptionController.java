package com.springboot.ibiza.surveyapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.ibiza.surveyapp.jpa.beans.AnswerOptionBean;
import com.springboot.ibiza.surveyapp.repositories.AnswerOptionRepository;

@CrossOrigin( origins = "*" )
@Controller
@RequestMapping("/api/v1/")
public class AnswerOptionController {
	Logger logger = Logger.getLogger(AnswerOptionController.class);
	@Autowired
	private AnswerOptionRepository answerOptionRepo;
	
	/*LIST ALL ANSWER OPTIONS*/
	@RequestMapping(value = "answeroptions", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<AnswerOptionBean> findAllAnswerOptions(){
		return answerOptionRepo.findAll();
	}
	
	/*FIND ANSWER OPTIONS BY ID*/
	@RequestMapping(value = "answeroption/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody AnswerOptionBean findAnswerOptionById(@PathVariable("id") String idStr){
		//return answerOptionRepo.find;
		return null;
	}
	
	/*SAVE LIST OF ANSWER OPTION*/
	@RequestMapping(value="/answeroptions", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AnswerOptionBean> saveAllAnswerOptions(@Valid @RequestBody List<AnswerOptionBean> answerOptions) {
		return answerOptionRepo.saveAll(answerOptions);
	}
	
	/*SAVE AN ANSWER OPTION*/
	@RequestMapping(value="/answeroption", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public AnswerOptionBean save(@Valid @RequestBody AnswerOptionBean answerOption) {
		return answerOptionRepo.save(answerOption);
	}
	
	

}
