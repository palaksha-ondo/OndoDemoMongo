package com.ondo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.ondo")
public class OndoMongoDBApp {

	public static void main(String[] args) {
		SpringApplication.run(OndoMongoDBApp.class, args);
	}
}