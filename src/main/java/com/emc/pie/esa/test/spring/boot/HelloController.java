package com.emc.pie.esa.test.spring.boot;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController
{

	@Autowired
	Environment env;

	@Autowired
	Date date;

	@RequestMapping("/")
	public String index()
	{
		System.out.println(date.toString());

		System.out.println(env.getProperty("endpoints.shutdown.enabled"));

		return "Greetings from spring boot!";
	}
}
