package org.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(proxyBeanMethods = false)
@EnableScheduling
public class FlowableApplication {
    public static void main(String[] args) {
        SpringApplication.run(FlowableApplication.class, args);
    }

}