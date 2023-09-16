package com.rest.test.rest_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @ComponentScan({ "main.controllers", "main.repositories" })
// @EnableJpaRepositories("main.repositories")
@SpringBootApplication
// @EnableJpaAuditing 
// @SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class RestTestApplication {
	public static void main(String[] args) {
		SpringApplication.run(RestTestApplication.class, args);
		System.out.println("Program is started now...");
	}

}
