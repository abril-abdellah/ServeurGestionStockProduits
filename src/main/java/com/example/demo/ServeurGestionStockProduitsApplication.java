package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.example.controller", "com.example.service"})
@EntityScan({"com.example.entity"})
//@EnableJpaRepositories({"repository"})
@SpringBootApplication
public class ServeurGestionStockProduitsApplication {

	public static void main(String[] args) {
		 SpringApplication.run(ServeurGestionStockProduitsApplication.class, args);
	}

}
