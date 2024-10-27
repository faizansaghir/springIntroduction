package com.example.springIntroduction.dependencyInjection_04.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 30 minutes";
    }
}
