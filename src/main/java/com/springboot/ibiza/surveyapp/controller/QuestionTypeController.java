package com.springboot.ibiza.surveyapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;


@CrossOrigin( origins = "*" )
@Controller
@RequestMapping("/api/v2/")
public class QuestionTypeController {
}
