package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan({"com.example.controller", "com.example.service", "com.example.security"})
@EntityScan({"com.example.entity"})
@EnableJpaRepositories({"com.example.repository"})
@SpringBootApplication
public class ServeurGestionStockProduitsApplication {

	public static void main(String[] args) {
		 SpringApplication.run(ServeurGestionStockProduitsApplication.class, args);
	}

}
