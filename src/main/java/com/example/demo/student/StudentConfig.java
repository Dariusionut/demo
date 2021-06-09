package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.JANUARY;
import static java.time.Month.JULY;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student Darius = new Student("Darius", "dariustinculescu@gmail.com",
                    LocalDate.of(1996, JANUARY, 26));
            Student Daniel = new Student("Daniel", "daniel@gmail.com",
                    LocalDate.of(2004, JULY, 11));

            repository.saveAll(
                    List.of(Darius, Daniel)
            );

        };
    }

}
