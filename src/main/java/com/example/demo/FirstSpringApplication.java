package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = { "com.example.demo", "com.example.demo.controller" })
@EntityScan(basePackages = { "com.example.demo.entity" })
@EnableJpaRepositories(basePackages = { "com.example.demo.repository", "com.example.demo.repository.DeleteRepository" })
@SpringBootApplication
public class FirstSpringApplication {

	public static void main(String[] args) {

		SpringApplication.run(FirstSpringApplication.class, args);
	}

}
