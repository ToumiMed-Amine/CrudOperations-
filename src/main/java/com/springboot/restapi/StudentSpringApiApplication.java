package com.springboot.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;

@SpringBootApplication
@EntityScan("com.springboot.restapi.entity")
public class StudentSpringApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentSpringApiApplication.class, args);
	}

}
