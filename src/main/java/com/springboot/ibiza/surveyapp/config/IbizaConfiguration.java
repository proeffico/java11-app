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

	public List<String> getMenus() {
		return menus;
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}

}
