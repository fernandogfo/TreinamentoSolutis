package com.contas.solutis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class SolutisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SolutisApplication.class, args);
	}

}
