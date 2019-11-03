package com.springboot.ibiza.surveyapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/*
 Cause we enable Spring Security for our application, so we have to configure it, 
 from that we could access to the resources in our application. By default setting 
 Spring Boot block access to H2 console. 
 
 */ 
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
		/*Allow all requests to the root url (“/”) */
		httpSecurity.authorizeRequests().antMatchers("/").permitAll().and()
		/*Allow all requests to the H2 database console url (“/h2/*”) */
		            .authorizeRequests().antMatchers("/h2/**").permitAll().and()
		            .authorizeRequests().antMatchers("/api/v1/**").permitAll()
		            ;
		
		/*Disable CSRF protection*/
		httpSecurity.csrf().disable();
		/*Disable X-Frame-Options in Spring Security*/
		httpSecurity.headers().frameOptions().disable();
		/*Disable headers*/
		httpSecurity.headers().disable();
    }
}
