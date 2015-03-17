package com.emc.pie.esa.test.spring.boot;

import java.io.IOException;

import org.springframework.boot.SpringApplication;

import com.emc.pie.esa.test.spring.AppConfig;

public class App {

	public static void main(String[] args) throws IOException {

		SpringApplication.run(AppConfig.class, args);

		System.out.println("Spring application starting success.");
	}
}
