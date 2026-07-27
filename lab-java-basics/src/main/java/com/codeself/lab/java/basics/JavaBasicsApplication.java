package com.codeself.lab.java.basics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.codeself.lab.java.basics", "com.codeself.lab.common"})
public class JavaBasicsApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaBasicsApplication.class, args);
    }
}
