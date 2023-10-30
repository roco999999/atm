package com.example.atmsimulation;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.atmsimulation.repository")
public class JpaConfig {
    // ... konfigürasyon ...
}

