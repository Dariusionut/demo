package com.example.demo.university;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UniversityConfig {

    @Bean
    CommandLineRunner commandLineRunner2(UniversityRepository repository) {
        return args -> {
            University poli = new University("Politehnica", "Romania", "Bucharest");

            repository.saveAll(
                    List.of(poli)
            );
        };
    }
}
