package com.example.springIntroduction.spring_09_postConstructAndPreDestroy.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    public CricketCoach() {
        System.out.println(STR."In constructor: \{getClass().getSimpleName()}");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }

    @PostConstruct
    public void setupMethod(){
        System.out.println(STR."In PostConstruct method: \{getClass().getSimpleName()}");
    }

    @PreDestroy
    public void destroyMethod(){
        System.out.println(STR."In PreDestroy method: \{getClass().getSimpleName()}");
    }
}

