package com.vuba.kafka.example.examplewithcommit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class KafkaApplicationWithManualCommit {

    public static void main(String[] args) {
        SpringApplication.run(KafkaApplicationWithManualCommit.class, args);
    }

}
