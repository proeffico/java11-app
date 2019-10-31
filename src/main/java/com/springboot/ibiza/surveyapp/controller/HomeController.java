package com.springboot.ibiza.surveyapp.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.ibiza.surveyapp.jpa.beans.QuestionBean;
import com.springboot.ibiza.surveyapp.service.CommonService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private CommonService service;
	
	@RequestMapping("")
    public String getHomeView(Model model){
		model.addAttribute("standardDate", new Date());
    	return "home";
    }
	
	//ALL QUESTIONARIES
	@RequestMapping("/questionaries")
	public String getGuestionariesView(Model model) {
		model.addAttribute("questionaries", service.findAllQuestionaries());
		return "Questionaries";
	}
	//
	@RequestMapping("/add/{id}")
	public String addQuestionToQuestionary(@PathVariable("id")Long id, Model model) {
		QuestionBean questionObject = new QuestionBean();
		questionObject.setQuestionaryBean(service.findQuestionaryById(id));
		model.addAttribute("questionObject", questionObject);
		
		return "AddQuestion";
	}
	

	@PostMapping("save_question")
	public String saveQuestion(QuestionBean questionObject) {
		service.createQuestion(questionObject);
		return "redirect: questionaries";
	}
		
	
}
