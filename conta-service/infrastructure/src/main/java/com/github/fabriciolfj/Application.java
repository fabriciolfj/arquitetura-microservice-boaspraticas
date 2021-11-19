package com.github.fabriciolfj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableFeignClients
@ComponentScan(basePackages = "com.github.fabriciolfj")
@EnableJpaRepositories(basePackages = "com.github.fabriciolfj.repository")
@EntityScan(basePackages = {"com.github.fabriciolfj.repository.conta", "com.github.fabriciolfj.repository.extrato"})
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
