package com.emc.pie.esa.test.spring;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { AppConfig.class })
@WebAppConfiguration
public class SpringWebAppContextTest {

	@Autowired
	ApplicationContext ctx;

	@Test
	public void printMgrBeans() throws Exception {

		String[] beanDefinitionNames = ctx.getBeanDefinitionNames();

		Arrays.sort(beanDefinitionNames);

		System.out.println(beanDefinitionNames.length);

		InputStream resourceAsStream = Thread.currentThread().getClass()
				.getResourceAsStream("/spring.beans.properties");

		BufferedReader reader = new BufferedReader(new InputStreamReader(resourceAsStream, "utf-8"));

		List<String> lines = new ArrayList<String>();

		String line = null;

		while ((line = reader.readLine()) != null) {
			lines.add(line);
		}

		for (String name : beanDefinitionNames) {
			if (!lines.contains(name)) {
				System.out.println(name);
				System.out.println(ctx.getType(name).toString());
			}
		}
	}
}
