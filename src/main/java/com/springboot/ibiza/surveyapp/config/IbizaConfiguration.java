package com.springboot.ibiza.surveyapp.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource(value = "classpath:ibiza.properties")
public class IbizaConfiguration {

	@Value("#{'${ibiza.home.menus}'.split(',')}")
	private List<String> menus;
	
	@Value("${ibiza.home.success}")
	private String success;

	@Value("${ibiza.home.close}")
	private String close;
	
	@Value("${ibiza.home.create-survey}")
	private String createSurvey;
	
	@Bean(name="menus")
	public List<String> getMenus() {
		return menus;
	}
	
	@Bean(name="success")
	public String getSuccess() {
		return success;
	}
	
	@Bean(name="close")
	public String getClose() {
		return close;
	}
	
	@Bean
	public String getCreateSurvey() {
		return createSurvey;
	}
	
	public void setMenus(List<String> menus) {
		this.menus = menus;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public void setClose(String close) {
		this.close = close;
	}

	public void setCreateSurvey(String createSurvey) {
		this.createSurvey = createSurvey;
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}

}
