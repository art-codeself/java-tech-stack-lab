package com.codeself.lab.scheduling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.codeself.lab.scheduling", "com.codeself.lab.common"})
public class TaskSchedulingApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskSchedulingApplication.class, args);
    }
}
