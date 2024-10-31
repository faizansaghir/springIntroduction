package com.example.springIntroduction.spring_10_configurationAndBean.common_non_modifiable;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

public class CricketCoach implements Coach {
    public CricketCoach() {
        System.out.println(STR."In constructor: \{getClass().getSimpleName()}");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }

}

