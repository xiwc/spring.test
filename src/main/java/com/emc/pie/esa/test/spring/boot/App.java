package com.emc.pie.esa.test.spring.boot;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.emc.pie.esa.test.spring.AppConfig;

@SpringBootApplication
@Import(AppConfig.class)
public class App {

	public static void main(String[] args) throws IOException {

		SpringApplication.run(App.class, args);

		System.out.println("Spring application starting success.");
	}
}
