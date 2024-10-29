package com.example.springIntroduction.dependencyInjection_07.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
    public TennisCoach() {
        System.out.println(STR."In constructor: \{getClass().getSimpleName()}");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }
}
