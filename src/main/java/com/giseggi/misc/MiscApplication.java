package com.giseggi.misc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MiscApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiscApplication.class, args);
	}

}
