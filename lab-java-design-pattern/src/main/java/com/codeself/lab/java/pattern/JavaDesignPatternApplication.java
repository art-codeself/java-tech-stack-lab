package com.codeself.lab.java.pattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.codeself.lab.java.pattern", "com.codeself.lab.common"})
public class JavaDesignPatternApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaDesignPatternApplication.class, args);
    }
}
