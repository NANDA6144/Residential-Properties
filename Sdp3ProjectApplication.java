package com.klef.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class Sdp3ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sdp3ProjectApplication.class, args);
		System.out.println("Server is Running and Wishing YoU a Prosperous Happy New Year ");
	}

}
