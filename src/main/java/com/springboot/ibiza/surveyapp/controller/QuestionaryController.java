package com.springboot.ibiza.surveyapp.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.ibiza.surveyapp.jpa.beans.QuestionaryBean;
import com.springboot.ibiza.surveyapp.jpa.beans.UserBean;
import com.springboot.ibiza.surveyapp.service.CommonService;

@CrossOrigin( origins = "*" )
@Controller
@RequestMapping("/api/v1/")
public class QuestionaryController {

	Logger logger = Logger.getLogger(QuestionaryController.class);
	@Autowired
	private CommonService service;
	
	/* REST API FOR ::QUESTIONARY:: OBJECT */
	@RequestMapping(value="/questionary", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<QuestionaryBean> createQuestionary(@Valid @RequestBody QuestionaryBean questionary) throws URISyntaxException {
		logger.info("Start creating a new questionary: "+questionary);
		UserBean user = service.createUser(new UserBean());
		logger.info("UserId: "+user.getUserId()+" has been created!");

		questionary.setUser(user);
		QuestionaryBean result = service.createQuestionary(questionary);
		logger.info("QuestionaryId: "+result.getQuestionaryId()+" has been created!");
		
		service.updateQuestionaryParentForQuestionsList(result.getQuestions(), result.getQuestionaryId());
		return ResponseEntity.created(new URI("/api/v1/questionaries/questionary/" + result.getQuestionaryId()))
	            .body(result);
	}
	
	@RequestMapping(value="questionaries", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<QuestionaryBean> findAllQuestionaries() {
		return service.findAllQuestionaries();
	}
	
	@RequestMapping(value="questionaries/questionary/{questionaryId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody QuestionaryBean findQuestionaryById(@PathVariable String questionaryId){
		try {
			Long id = Long.parseLong(questionaryId);
			return service.findQuestionaryById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new QuestionaryBean();
		}
	}
	
}
