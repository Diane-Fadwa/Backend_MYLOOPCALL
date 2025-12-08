package com.fadwa.myloopcall;

import org.springframework.boot.SpringApplication;

public class MyLoopCallApplication {
    public static void main(String[] args) {
        SpringApplication.from(MyLoopCallApplication::main).with(TestcontainersConfiguration.class).run(args);
    }
}