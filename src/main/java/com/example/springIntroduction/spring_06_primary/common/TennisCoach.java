package com.example.springIntroduction.spring_06_primary.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }
}
