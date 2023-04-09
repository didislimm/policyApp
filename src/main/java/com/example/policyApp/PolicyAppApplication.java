package com.example.policyApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages = "com.example.policyApp.entity")
public class PolicyAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(PolicyAppApplication.class, args);
	}

}
