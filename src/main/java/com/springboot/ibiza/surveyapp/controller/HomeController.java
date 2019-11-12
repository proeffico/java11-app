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
import com.springboot.ibiza.surveyapp.repositories.QuestionRepository;
import com.springboot.ibiza.surveyapp.repositories.QuestionTypeRepository;
import com.springboot.ibiza.surveyapp.repositories.QuestionaryRepository;

@Controller
@RequestMapping("/")
public class HomeController {
	Logger logger = Logger.getLogger(HomeController.class);
	
	@Autowired
	private QuestionTypeRepository questionTypeRepo;
	
	@Autowired
	private QuestionaryRepository questionaryRepo;
	
	@Autowired
	private QuestionRepository questionRepo;
	
	@Autowired
	private IbizaConfiguration ibizaConfig;
	
	@RequestMapping("")
    public String getHomePageView(Model model){
		model.addAttribute("standardDate", new Date());
		model.addAttribute("questionTypes", questionTypeRepo.findAll());
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
		model.addAttribute("questionaries", questionaryRepo.findAll());
		return "list-of-questionary";
	}
	/*QUESTIONARY'S INFO*/
	@RequestMapping(value="/questionaries/questionary/{id}", method = RequestMethod.GET)
	public String getQuestionaryInfo(@PathVariable("id") String idStr, Model model){
		logger.info("Start searching questionary from database..."+ idStr);
		QuestionaryBean questionaryObj = questionaryRepo.findByQuestionaryId(Long.parseLong(idStr));
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
		QuestionaryBean questionary = questionaryRepo.findByQuestionaryId(Long.parseLong(idStr));
		System.out.println(questionary);

		model.addAttribute("questionary", questionary); 
		model.addAttribute("questionsOfQuestionary", questionary.getQuestions());
		model.addAttribute("questionTypes", questionTypeRepo.findAll());
		System.out.print(questionTypeRepo.findAll());
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
		questionRepo.save(questionObject);
		
		return "redirect:questionaries";
	}
		
	
}
