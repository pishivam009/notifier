package com.piyush.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NotifierAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotifierAppApplication.class, args);
		System.out.println("Running");
	}

}
