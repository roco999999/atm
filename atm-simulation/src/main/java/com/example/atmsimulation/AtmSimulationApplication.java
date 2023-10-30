package com.example.atmsimulation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.example.atmsimulation.model")
public class AtmSimulationApplication {
    public static void main(String[] args) {
        SpringApplication.run(AtmSimulationApplication.class, args);
    }
}

