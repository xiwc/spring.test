package com.emc.pie.esa.test.spring.boot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

public class Application
{
	public static void main(String[] args) throws IOException
	{
		ApplicationContext ctx = SpringApplication.run(AppConfig.class, args);

		System.out.println("Let's inspect the beans provided by spring Boot:");

		String[] beanDefinitionNames = ctx.getBeanDefinitionNames();

		Arrays.sort(beanDefinitionNames);

		System.out.println(beanDefinitionNames.length);

		InputStream resourceAsStream = Thread.currentThread().getClass()
				.getResourceAsStream("/spring.beans.properties");

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				resourceAsStream, "utf-8"));

		List<String> lines = new ArrayList<String>();

		String line = null;

		while ((line = reader.readLine()) != null)
		{
			lines.add(line);
		}

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
