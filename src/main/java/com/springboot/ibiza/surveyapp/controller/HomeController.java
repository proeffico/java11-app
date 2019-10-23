package com.springboot.ibiza.surveyapp.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
	@RequestMapping("")
    public String getHomeView(Model model){
		model.addAttribute("standardDate", new Date());
    	return "home";
    }
}
