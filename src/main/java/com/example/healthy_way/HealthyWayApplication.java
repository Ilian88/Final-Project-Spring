package com.example.healthy_way;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class HealthyWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealthyWayApplication.class, args);
    }

}
