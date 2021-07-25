package com.github.fabriciolfj.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = "com.github.fabriciolfj")
@EnableJpaRepositories(basePackages = "com.github.fabriciolfj.repository")
@EntityScan(basePackages = {"com.github.fabriciolfj.repository.product.model", "com.github.fabriciolfj.repository.extract.model"})
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}