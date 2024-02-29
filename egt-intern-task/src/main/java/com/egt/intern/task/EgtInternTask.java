package com.egt.intern.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class EgtInternTask {

	public static void main(String[] args) {
		SpringApplication.run(EgtInternTask.class, args);
	}

}
