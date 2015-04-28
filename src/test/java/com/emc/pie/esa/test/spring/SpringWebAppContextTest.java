package com.emc.pie.esa.test.spring;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { Application.class })
@WebAppConfiguration
@TestPropertySource("/application-beans.properties")
public class SpringWebAppContextTest {

	static Logger logger = Logger.getLogger(SpringWebAppContextTest.class);

	@Autowired
	ApplicationContext ctx;

	@Autowired
	Environment env;

	@Test
	public void printMgrBeans() throws Exception {

		String[] names = ctx.getBeanDefinitionNames();

		Arrays.sort(names);

		logger.debug(names.length);
		logger.info(names.length);

		Arrays.stream(names).forEach((name) -> {
			System.out.println(String.format("%s=%s", name, ctx.getType(name).toString()));
		});

		org.junit.Assert.assertTrue(env.containsProperty("actuatorMetricRepository"));

	}
}
