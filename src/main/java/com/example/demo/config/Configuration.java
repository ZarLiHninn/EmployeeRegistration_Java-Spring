package com.example.demo.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@org.springframework.context.annotation.Configuration
public class Configuration extends WebMvcConfigurerAdapter {
	@Bean
	@Qualifier("work_places")
	public List<String> work_places(){
		return Arrays.asList("SALES","HR","IT");
	}
	
}
