package com.example.springIntroduction.sample_01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan
public class MainRunner {
    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(MainRunner.class)) {
            var businessCalculationService = context.getBean(BusinessCalculationService.class);
            System.out.println(businessCalculationService.getMax());
        }
    }
}
