package com.springboot.ibiza.surveyapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.ibiza.surveyapp.jpa.beans.QuestionBean;
import com.springboot.ibiza.surveyapp.jpa.beans.QuestionaryBean;
import com.springboot.ibiza.surveyapp.repositories.QuestionRepository;

@Service
public class CommonServiceImpl implements CommonService {

	@Autowired
	private QuestionRepository questionRepo;
	
<<<<<<< HEAD
	@Autowired
	private QuestionaryRepository questionaryRepo;
	
	@Autowired
	private QuestionTypeRepository questionTypeRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public List<AnswerBean> findAllAnswers() {
		return answerRepo.findAll();
	}

	@Override
	public List<QuestionBean> findAllQuestions() {
		return questionRepo.findAll();
	}

	@Override
	public List<QuestionaryBean> findAllQuestionaries() {
		return questionaryRepo.findAll();
	}

	@Override
	public QuestionaryBean createQuestionary(QuestionaryBean questionaryBean) {
		return questionaryRepo.save(questionaryBean);
	}

	@Override
	public QuestionBean createQuestion(QuestionBean questionBean) {
		return questionRepo.save(questionBean);
	}

	
	@Override
	public AnswerBean createAnswer(AnswerBean answerBean) {
		return answerRepo.save(answerBean);
	}

	public QuestionaryBean findQuestionaryById(Long id) {
		return (questionaryRepo.findByQuestionaryId(id) != null)? questionaryRepo.findByQuestionaryId(id) : new QuestionaryBean();
	}

	@Override
	public List<QuestionTypeBean> findAllQuestionTypes() {
		return questionTypeRepo.findAll();
	}

	@Override
	public UserBean createUser(UserBean user) {
		return userRepo.save(user);
	}

=======
>>>>>>> ebc62eb48ac8c52ce7992cfd50ba6d8c5ef02f15
	@Override
	public List<QuestionBean> updateQuestionaryParentForQuestionsList(List<QuestionBean> questions, Long questionaryId) {
		questions.forEach(question -> {
			QuestionaryBean questionary = new QuestionaryBean();
			questionary.setQuestionaryId(questionaryId);
			question.setQuestionary(questionary);
		});
		return questionRepo.saveAll(questions);
	}
}
