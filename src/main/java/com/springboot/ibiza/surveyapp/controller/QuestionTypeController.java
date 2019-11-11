package com.springboot.ibiza.surveyapp.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.ibiza.surveyapp.service.CommonService;


@CrossOrigin( origins = "*" )
@Controller
@RequestMapping("/api/v1/")
public class QuestionTypeController {
   
	@Autowired
	private CommonService service;
}
