package com.santosh.springjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = { "com.santosh.springjpa.repo" })
@EntityScan(basePackages = { "com.santosh.springjpa.model" })
@SpringBootApplication(scanBasePackages = { "com.santosh" })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
