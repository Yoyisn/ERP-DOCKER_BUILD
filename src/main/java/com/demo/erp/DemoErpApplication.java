package com.demo.erp;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
public class DemoErpApplication {
    public static void main(String[] args) {
        System.out.println("Corriendo Spring >>>>");
        SpringApplication.run(DemoErpApplication.class, args);
    };
};