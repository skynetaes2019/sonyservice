package com.sony.sonyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SonyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SonyServiceApplication.class, args);
	}

}
