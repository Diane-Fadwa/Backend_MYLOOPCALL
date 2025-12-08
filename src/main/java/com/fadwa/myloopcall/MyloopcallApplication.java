package com.fadwa.myloopcall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.fadwa.myloopcall.repository")
@EntityScan(basePackages = "com.fadwa.myloopcall.entity")
@SpringBootApplication
public class MyloopcallApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyloopcallApplication.class, args);
    }

}
