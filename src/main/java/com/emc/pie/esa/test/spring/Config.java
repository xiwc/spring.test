package com.emc.pie.esa.test.spring;

import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

	@Bean
	Date date() {
		return new Date();
	}
}
