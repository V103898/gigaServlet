package ru.netology.servlets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
abstract class ServletsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServletsApplication.class, args);
    }

}
