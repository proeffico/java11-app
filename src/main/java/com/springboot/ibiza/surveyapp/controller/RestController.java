package com.springboot.ibiza.surveyapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.ibiza.surveyapp.jpa.beans.AnswerBean;
import com.springboot.ibiza.surveyapp.jpa.beans.QuestionBean;
import com.springboot.ibiza.surveyapp.jpa.beans.QuestionaryBean;
import com.springboot.ibiza.surveyapp.service.CommonService;

@Controller
@RequestMapping("/api/v1/")
public class RestController {
    
	@Autowired
	private CommonService service;
	
	/* REST API FOR ::ANSWER:: OBJECT */
	@RequestMapping(value = "answers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<AnswerBean> findAllAnswers(){
		return service.findAllAnswers();
	}
	
	@RequestMapping(value="/answers", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public AnswerBean save(@Valid @RequestBody AnswerBean answerBean) {
		return service.createAnswer(answerBean);
	}
	
	/* REST API FOR ::QUESTION:: OBJECT */
	@RequestMapping(value="/questions", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<QuestionBean> questionRest() {
		return service.findAllQuestions();
	}
	
	@RequestMapping(value="/questions", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public QuestionBean save(@Valid @RequestBody QuestionBean questionBean) {
		return service.createQuestion(questionBean);
	}
	
	/* REST API FOR ::QUESTIONARY:: OBJECT */
	@RequestMapping(value="/questionaries", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public QuestionaryBean save(@Valid @RequestBody QuestionaryBean questionaryBean) {
		return service.createQuestionary(questionaryBean);
	}
	
	@RequestMapping(value="questionaries", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<QuestionaryBean> findAllQuestionaries() {
		return service.findAllQuestionaries();
	}
	
	
	//REST SERVICE USING ID
/*	@RequestMapping(value="/questions/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<QuestionBean> findQuestionRest(@PathVariable("questionId")Long id) {
		return qrepo.findById(id);
	}
	//ADDING QUESTION WITH THIS
	@RequestMapping(value="/add")
	public String addQuestion(Model model) {
		model.addAttribute("question", new QuestionBean());
		return "AddQuestion";
	}
	@RequestMapping(value="/add/{id}")
	public String addQuestion(@PathVariable("id")Long id,Model model) {
		model.addAttribute("question", new QuestionBean(id));
		//model.addAttribute("questionary", querepo.findById(id));
		return "AddQuestion";
	}*/
	

	
	
}
