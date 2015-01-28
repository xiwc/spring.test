package com.emc.pie.esa.test.spring.boot;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.emc.pie.esa.test.spring.boot.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { Application.class,
		MockServletContext.class })
@WebAppConfiguration
public class HelloControllerTest
{
	@Autowired
	WebApplicationContext context;

	MockMvc mvc;

	@Before
	public void setup() throws Exception
	{
		// mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void getHello() throws Exception
	{
		mvc.perform(
				MockMvcRequestBuilders.get("/").accept(
						MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(
						MockMvcResultMatchers.content().string(
								Matchers.is("Greetings from spring boot!")));
	}
}
