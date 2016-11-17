package com.untitled.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = { "com.untitled.data.entity" }) 
@EnableJpaRepositories(basePackages = { "com.untitled.data.repo" })
public class WebBaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebBaseApplication.class, args);
	}
}
