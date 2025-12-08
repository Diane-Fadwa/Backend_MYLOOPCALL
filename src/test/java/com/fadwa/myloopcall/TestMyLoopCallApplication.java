package com.fadwa.myloopcall;

import org.springframework.boot.SpringApplication;

public class TestMyLoopCallApplication {
    public static void main(String[] args) {
        SpringApplication.from(TestMyLoopCallApplication::main).with(TestcontainersConfiguration.class).run(args);
    }
}