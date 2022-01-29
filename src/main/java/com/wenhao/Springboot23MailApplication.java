package com.wenhao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Springboot23MailApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot23MailApplication.class, args);
    }

}
