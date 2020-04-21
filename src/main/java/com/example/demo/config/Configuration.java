package com.example.demo.config;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 
 * @author Zar Li Hnin
 *
 */
@org.springframework.context.annotation.Configuration
public class Configuration extends WebMvcConfigurerAdapter {

	@Bean
	@Qualifier("genders")
	public List<String> genders() {
		return Arrays.asList("MALE", "FEMALE");
	}

}
