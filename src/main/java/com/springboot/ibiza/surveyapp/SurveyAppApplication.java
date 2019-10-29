package com.springboot.ibiza.surveyapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.springboot.ibiza.surveyapp"})
//@EnableJpaRepositories(basePackages = {"com.springboot.ibiza.surveyapp.repositories"})
@EnableGlobalMethodSecurity(prePostEnabled = true, proxyTargetClass = true)
@EntityScan(basePackages = "com.springboot.ibiza.surveyapp.jpa.beans")
public class SurveyAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SurveyAppApplication.class, args);
	}

}
