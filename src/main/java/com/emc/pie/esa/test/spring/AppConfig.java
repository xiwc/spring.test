package com.emc.pie.esa.test.spring;

import java.util.Date;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@PropertySource(value = "classpath:application.properties")
public class AppConfig {

	@Bean
	Date date() {
		return new Date();
	}
}
