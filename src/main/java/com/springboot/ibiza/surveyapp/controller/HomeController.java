package com.springboot.ibiza.surveyapp.controller;

import java.util.ArrayList;
import java.util.Date;

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
	/*INSERT A NEW QUESTIONARY*/
	@RequestMapping(value= "/questionary", method = RequestMethod.POST)
	public String addQuestionary(){
		return null;
	}
	
	@RequestMapping(value = "/add/{id}", method = RequestMethod.GET)
	public String addQuestionToQuestionary(@PathVariable("id")String idStr, Model model) {
		QuestionBean questionObject = new QuestionBean();
		questionObject.setQuestionaryBean(service.findQuestionaryById(Long.parseLong(idStr)));
		model.addAttribute("questionObject", questionObject);
		return "AddQuestion";
	}
	
	@RequestMapping(value="/save_question", method = RequestMethod.POST)
	public String saveQuestion(QuestionBean questionObject) {
		service.createQuestion(questionObject);
		return "redirect:questionaries";
	}
		
	
}
