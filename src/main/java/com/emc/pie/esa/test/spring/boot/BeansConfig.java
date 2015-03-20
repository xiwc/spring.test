package com.emc.pie.esa.test.spring.boot;

import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {
	
	@Bean
	Date date()
	{
		return new Date();
	}
}
