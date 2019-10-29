package com.springboot.ibiza.surveyapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.ibiza.surveyapp.dao.answerDAO.AnswerDao;
import com.springboot.ibiza.surveyapp.domain.AnswerDomain;
import com.springboot.ibiza.surveyapp.domainJPA.Question;
import com.springboot.ibiza.surveyapp.domainJPA.QuestionRepository;
import com.springboot.ibiza.surveyapp.domainJPA.Questionary;
import com.springboot.ibiza.surveyapp.domainJPA.QuestionaryRepository;

@Controller
@RequestMapping("/api/v1/")
public class RestController {
    
	/*@Autowired
	private AnswerDao answerDao;*/
	
	@Autowired
	private QuestionRepository qrepo;
	
	@Autowired
	private QuestionaryRepository querepo;
	
	/*@RequestMapping(value = "answers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<AnswerDomain> findAllAnswers(){
		return answerDao.findAllAnswers();
	}*/
	
	@RequestMapping(value="/questions", method = RequestMethod.GET)
	public @ResponseBody List<Question> questionRest() {
		return(List<Question>)qrepo.findAll();
	}
	
	//REST SERVICE USING ID
	@RequestMapping(value="/questions/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Question> findQuestionRest(@PathVariable("questionId")Long id) {
		return qrepo.findById(id);
	}
	//ADDING QUESTION WITH THIS
	@RequestMapping(value="/add")
	public String addQuestion(Model model) {
		model.addAttribute("question", new Question());
		return "AddQuestion";
	}
	@RequestMapping(value="/add/{id}")
	public String addQuestion(@PathVariable("id")Long id,Model model) {
		model.addAttribute("question", new Question(id));
		//model.addAttribute("questionary", querepo.findById(id));
		return "AddQuestion";
	}
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("question") Question question,
			@ModelAttribute("questionary") Questionary questionary) {
		qrepo.save(question);
		return "redirect:../Questionaries";
	}
	//Shows all questionarys
	@RequestMapping(value="questionaries")
	public String questionarysFind(Model model) {
		model.addAttribute("questionaries", querepo.findAll());
		return "Questionaries";
	}
	
	
}
