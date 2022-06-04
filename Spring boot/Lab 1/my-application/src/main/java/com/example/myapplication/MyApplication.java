package com.example.myapplication;

import gov.iti.jets.HelloService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(HelloService helloService){
        return args -> {
            helloService.sayHello("hello");
        };
    }



}
