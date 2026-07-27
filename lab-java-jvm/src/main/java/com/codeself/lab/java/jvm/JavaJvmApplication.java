package com.codeself.lab.java.jvm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.codeself.lab.java.jvm", "com.codeself.lab.common"})
public class JavaJvmApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaJvmApplication.class, args);
    }
}
