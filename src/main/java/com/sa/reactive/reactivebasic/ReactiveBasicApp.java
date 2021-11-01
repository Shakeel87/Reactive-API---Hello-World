package com.sa.reactive.reactivebasic;


import com.sa.reactive.reactivebasic.dao.EmployeeRepository;
import com.sa.reactive.reactivebasic.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Duration;
import java.util.Arrays;

@SpringBootApplication
public class ReactiveBasicApp {
	private static final Logger log = LoggerFactory.getLogger(ReactiveBasicApp.class);

	public static void main(String[] args) {
		SpringApplication.run(ReactiveBasicApp.class, args);
	}


	@Bean
	public CommandLineRunner demo(EmployeeRepository repository) {

		return (args) -> {
			// save a few customers
			repository.saveAll(Arrays.asList(new Employee("Shakeel", "Ahmad","abc@xyz.com"),
							new Employee("Zaid", "Ahmad","zaid@xyz.com"),
							new Employee("Zaira", "Shakeel","abc@xyz.com"),
							new Employee("Salma", "Salma","abc@xyz.com")))
					.blockLast(Duration.ofSeconds(10));
			log.info("Insert done!!");
         repository.findAll()
				 .doOnNext(emp->log.info(emp.toString()))
				 .blockLast(Duration.ofSeconds(10));
		};
	}


}
