package com.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class SpringBootThymeleafApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringBootThymeleafApplication.class, args);
	}

}
