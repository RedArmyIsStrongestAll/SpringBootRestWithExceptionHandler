package ru.petrov.fullRestAPI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FullRestApiApplication {

	@Bean
	public Logger logger(){
		return LoggerFactory.getLogger("application");
	}

	public static void main(String[] args) {
		SpringApplication.run(FullRestApiApplication.class, args);
	}

}
