package com.vuba.kafka.example.simple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class SimpleKafkaApp {

	public static void main(String[] args) {
		SpringApplication.run(SimpleKafkaApp.class, args);
	}

}
