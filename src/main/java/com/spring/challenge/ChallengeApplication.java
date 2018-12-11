package com.spring.challenge;

import com.spring.challenge.configuration.ApplicationConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(ApplicationConfiguration.class)
public class ChallengeApplication {
	public static void main(String[] args) {
		SpringApplication.run(ChallengeApplication.class, args);
	}
}
