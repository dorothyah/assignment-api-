package com.sparta.memotest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MemotestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemotestApplication.class, args);
    }

}
