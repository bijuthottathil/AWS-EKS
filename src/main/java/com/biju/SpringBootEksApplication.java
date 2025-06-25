package com.biju;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
@RestController
public class SpringBootEksApplication {

    private final MeterRegistry meterRegistry;

    @Autowired
    public SpringBootEksApplication(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @GetMapping("/greetings")
    public String message() {
        meterRegistry.counter("custom.greetings.requests").increment();
        return "Welcome to Biju ! app deployed in AWS EKS.Hello from EKSsp";
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootEksApplication.class, args);
    }


}
