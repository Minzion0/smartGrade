package com.green.smartGrade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SmartGradeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartGradeApplication.class, args);
	}

}
