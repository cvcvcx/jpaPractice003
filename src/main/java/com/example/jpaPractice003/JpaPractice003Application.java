package com.example.jpaPractice003;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class JpaPractice003Application {

	public static void main(String[] args) {
		SpringApplication.run(JpaPractice003Application.class, args);
	}

}
