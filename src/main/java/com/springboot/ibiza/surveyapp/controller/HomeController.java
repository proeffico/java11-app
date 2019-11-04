package com.springboot.ibiza.surveyapp.controller;

import java.util.Date;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.ibiza.surveyapp.jpa.beans.QuestionBean;
import com.springboot.ibiza.surveyapp.jpa.beans.QuestionaryBean;
import com.springboot.ibiza.surveyapp.service.CommonService;

@Controller
@RequestMapping("/")
public class HomeController {
	Logger logger = Logger.getLogger(HomeController.class);
	
	@Autowired
	private CommonService service;
	
	@RequestMapping("")
    public String getHomeView(Model model){
		model.addAttribute("standardDate", new Date());
		model.addAttribute("questionTypes", service.findAllQuestionTypes());
    	return "home";
    }
	
	/*LIST ALL QUESTIONARIES*/
	@RequestMapping(value= "/questionaries", method = RequestMethod.GET)
	public String getGuestionariesView(Model model) {
		model.addAttribute("questionaries", service.findAllQuestionaries());
		return "Questionaries";
	}
	/*QUESTIONARY'S INFO*/
	@RequestMapping(value="/questionaries/questionary/{id}", method = RequestMethod.GET)
	public String getQuestionaryInfo(@PathVariable("id") String idStr, Model model){
		logger.info("Start searching questionary from database..."+ idStr);
		model.addAttribute("questionaryObj", service.findQuestionaryById(Long.parseLong(idStr)));
		return "questionary-info";
	}
	
	/*INSERT A NEW QUESTIONARY*/
	@RequestMapping(value= "/questionary", method = RequestMethod.POST)
	public String addQuestionary(){
		return null;
	}
	
	@RequestMapping(value = "/add/{id}", method = RequestMethod.GET)
	public String addQuestionToQuestionary(@PathVariable("id") String idStr, Model model) {
		QuestionBean questionObject = new QuestionBean();
		QuestionaryBean questionary = service.findQuestionaryById(Long.parseLong(idStr));
		System.out.println(questionary);
		questionObject.setQuestionaryBean(questionary);
		System.out.println(questionObject.getQuestionaryBean());//setting the QuestionaryBean works
		model.addAttribute("questionObject", questionObject);
		model.addAttribute("questionary", questionary); 
		model.addAttribute("questionsOfQuestionary", questionary.getQuestions());
		model.addAttribute("questionTypes", service.findAllQuestionTypes());
		
		return "AddQuestion";
	}
	
	@RequestMapping(value="/save_question", method = RequestMethod.POST)
	public String saveQuestion(QuestionBean questionObject) {
		
		//okei eli jostain syystä alla oleva QuestionaryBean olion haku ei onnistu vaikka 
		//olen aikaisemmin setannut sen Questionbean olioon
		//antaa metodeita kutsuttaessa null pointer exceptionii
		System.out.println(questionObject.getQuestion());
		System.out.println(questionObject.getQuestionaryBean());//tää antaa null vaikka se QuestionaryBean on setattu siihen QuestionBean olioon aikaisemmin
		//QuestionaryBean questionary = questionObject.getQuestionaryBean();
		//List<QuestionBean> questionList = questionary.getQuestions();
		//questionList.add(questionObject);
		//questionary.setQuestions(questionList);
		//service.createQuestion(questionObject);
		service.createQuestion(questionObject);
		
		return "redirect:questionaries";
	}
		
	
}
