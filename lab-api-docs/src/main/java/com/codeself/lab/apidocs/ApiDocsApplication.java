package com.codeself.lab.apidocs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.codeself.lab.apidocs", "com.codeself.lab.common"})
public class ApiDocsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiDocsApplication.class, args);
    }
}
