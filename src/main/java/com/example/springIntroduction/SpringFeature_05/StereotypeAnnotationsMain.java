package com.example.springIntroduction.SpringFeature_05;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class StereotypeAnnotationsMain {
    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(StereotypeAnnotationsMain.class)) {
            var businessCalculationService = context.getBean(BusinessCalculationService.class);
            System.out.println(businessCalculationService.getMax());
        }
    }
}
