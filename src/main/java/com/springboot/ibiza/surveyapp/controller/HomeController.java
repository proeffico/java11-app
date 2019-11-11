package com.springboot.ibiza.surveyapp.controller;

import java.util.Date;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.ibiza.surveyapp.config.IbizaConfiguration;
import com.springboot.ibiza.surveyapp.jpa.beans.QuestionBean;
import com.springboot.ibiza.surveyapp.jpa.beans.QuestionaryBean;
import com.springboot.ibiza.surveyapp.service.CommonService;

@Controller
@RequestMapping("/")
public class HomeController {
	Logger logger = Logger.getLogger(HomeController.class);
	
	@Autowired
	private CommonService service;
	
	@Autowired
	private IbizaConfiguration ibizaConfig;
	
	@RequestMapping("")
    public String getHomePageView(Model model){
		model.addAttribute("standardDate", new Date());
		model.addAttribute("questionTypes", service.findAllQuestionTypes());
		model.addAttribute("menus", ibizaConfig.getMenus());
		model.addAttribute("success", ibizaConfig.getSuccess());
		model.addAttribute("close", ibizaConfig.getClose());
		model.addAttribute("createSurvey", ibizaConfig.getCreateSurvey());
    	return "home";
    }
	
	@RequestMapping("restinfo")
    public String getRestInfoPageView(Model model){
		model.addAttribute("menus", ibizaConfig.getMenus());
    	return "restinfo";
    }
	
	@RequestMapping("documentation")
    public String getDocumentationPageView(Model model){
		model.addAttribute("menus", ibizaConfig.getMenus());
    	return "documentation";
    }
	
	@RequestMapping("about")
    public String getAboutPageView(Model model){
		model.addAttribute("menus", ibizaConfig.getMenus());
    	return "about";
    }
	
	/*LIST ALL QUESTIONARIES*/
	@RequestMapping(value= "/questionaries", method = RequestMethod.GET)
	public String getGuestionariesView(Model model) {
		model.addAttribute("questionaries", service.findAllQuestionaries());
		return "list-of-questionary";
	}
	/*QUESTIONARY'S INFO*/
	@RequestMapping(value="/questionaries/questionary/{id}", method = RequestMethod.GET)
	public String getQuestionaryInfo(@PathVariable("id") String idStr, Model model){
		logger.info("Start searching questionary from database..."+ idStr);
		QuestionaryBean questionaryObj = service.findQuestionaryById(Long.parseLong(idStr));
		logger.info(questionaryObj.toString());
		model.addAttribute("questionaryObj", questionaryObj);
		return "questionary-info";
	}
	
	/*INSERT A NEW QUESTIONARY*/
	@RequestMapping(value= "/questionary", method = RequestMethod.POST)
	public String addQuestionary(){
		return null;
	}
	
	@RequestMapping(value = "/add/{id}", method = RequestMethod.GET)
	public String addQuestionToQuestionary(@PathVariable("id") String idStr, Model model) {
		QuestionaryBean questionary = service.findQuestionaryById(Long.parseLong(idStr));
		System.out.println(questionary);

		model.addAttribute("questionary", questionary); 
		model.addAttribute("questionsOfQuestionary", questionary.getQuestions());
		model.addAttribute("questionTypes", service.findAllQuestionTypes());
		System.out.print(service.findAllQuestionTypes());
		return "questionary-setting";
	}
	
	@RequestMapping(value="/save_question", method = RequestMethod.POST)
	public String saveQuestion(QuestionBean questionObject) {
		
		//okei eli jostain syystä alla oleva QuestionaryBean olion haku ei onnistu vaikka 
		//olen aikaisemmin setannut sen Questionbean olioon
		//antaa metodeita kutsuttaessa null pointer exceptionii
		System.out.println(questionObject.getQuestion());

		//QuestionaryBean questionary = questionObject.getQuestionaryBean();
		//List<QuestionBean> questionList = questionary.getQuestions();
		//questionList.add(questionObject);
		//questionary.setQuestions(questionList);
		//service.createQuestion(questionObject);
		service.createQuestion(questionObject);
		
		return "redirect:questionaries";
	}
		
	
}
