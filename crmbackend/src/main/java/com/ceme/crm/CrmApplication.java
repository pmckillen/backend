package com.ceme.crm;

import com.ceme.crm.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
// Tell Spring boot where the repos are.
@EnableMongoRepositories(basePackages = "com.ceme.crm.repository")
@OpenAPIDefinition // http://localhost:8080/swagger-ui.html
public class CrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrmApplication.class, args);
	}



}
