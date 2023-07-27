package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.cybage")
public class MySpaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpaceApplication.class, args);
	}

}
