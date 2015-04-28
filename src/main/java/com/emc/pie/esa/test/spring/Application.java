package com.emc.pie.esa.test.spring;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws IOException {

		SpringApplication.run(Application.class, args);

		System.out.println("Spring application starting success.");
	}
}
