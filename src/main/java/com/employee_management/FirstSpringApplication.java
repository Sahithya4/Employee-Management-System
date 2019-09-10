package com.employee_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = { "com.employee_management", "com.employee_management.controller" })
@EntityScan(basePackages = { "com.employee_management.entity" })
@EnableJpaRepositories(basePackages = { "com.employee_management.repository", "com.employee_management.repository.DeleteRepository" })
@SpringBootApplication
public class FirstSpringApplication {

	public static void main(String[] args) {

		SpringApplication.run(FirstSpringApplication.class, args);
	}

}
