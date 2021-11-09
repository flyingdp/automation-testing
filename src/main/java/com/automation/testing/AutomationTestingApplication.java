package com.automation.testing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.automation.testing")
public class AutomationTestingApplication {
    public static void main(String[] args) {
        SpringApplication.run(AutomationTestingApplication.class, args);
    }

}
