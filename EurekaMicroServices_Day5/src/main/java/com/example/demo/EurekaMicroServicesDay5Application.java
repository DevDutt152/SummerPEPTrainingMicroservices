package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaMicroServicesDay5Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaMicroServicesDay5Application.class, args);
		System.out.println("Main Started");
	}

}
