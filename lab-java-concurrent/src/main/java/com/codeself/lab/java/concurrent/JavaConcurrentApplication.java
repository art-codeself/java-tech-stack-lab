package com.codeself.lab.java.concurrent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.codeself.lab.java.concurrent", "com.codeself.lab.common"})
public class JavaConcurrentApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaConcurrentApplication.class, args);
    }
}
