package com.example.ExcelUpDown;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.example.newEntity")
public class ExcelUpDownApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExcelUpDownApplication.class, args);
	}
	
	

}
