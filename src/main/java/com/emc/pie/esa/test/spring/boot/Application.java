package com.emc.pie.esa.test.spring.boot;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.emc.pie.esa.test.spring.Test;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@PropertySource(value = "classpath:application.properties")
public class Application
{

	@Bean
	Date date()
	{
		return new Date();
	}

	public static void main(String[] args) throws IOException
	{
		ApplicationContext ctx = SpringApplication.run(Application.class, args);

		System.out.println("Let's inspect the beans provided by spring Boot:");

		String[] beanDefinitionNames = ctx.getBeanDefinitionNames();

		Arrays.sort(beanDefinitionNames);

		System.out.println(beanDefinitionNames.length);

		URL resource = Test.class.getResource("/spring.beans.properties");

		System.out.println(resource.toString());

		List<String> lines = FileUtils.readLines(FileUtils.toFile(resource),
				"utf-8");

		for (String name : beanDefinitionNames)
		{
			if (!lines.contains(name))
			{
				System.out.println(name);
				System.out.println(ctx.getType(name).toString());
			}
		}
	}
}
