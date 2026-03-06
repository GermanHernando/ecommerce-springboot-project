package com.mycompany.app;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.mycompany.app", "services"})
@EntityScan(basePackages = {"models"})
@EnableJpaRepositories(basePackages = {"repositories"})
public class App{
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
