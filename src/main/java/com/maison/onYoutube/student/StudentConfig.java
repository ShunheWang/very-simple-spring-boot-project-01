package com.maison.onYoutube.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student maison = new Student(
                    1L,
                    "Maison",
                    "maisonwangsh@gmail.com",
                    LocalDate.of(2000, Month.NOVEMBER, 7),
                    21
            );

            Student okay = new Student(
                    1L,
                    "Okay",
                    "ok@gmail.com",
                    LocalDate.of(2001, Month.JANUARY, 1),
                    20
            );

            Student alex = new Student(
                    1L,
                    "Alex",
                    "alex@gmail.com",
                    LocalDate.of(2003, Month.JANUARY, 1),
                    19
            );

            repository.saveAll(
                    List.of(maison, okay, alex)
            );

        };
    }

}
