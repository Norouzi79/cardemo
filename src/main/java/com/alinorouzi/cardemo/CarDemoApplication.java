package com.alinorouzi.cardemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class CarDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarDemoApplication.class, args);
    }

}
