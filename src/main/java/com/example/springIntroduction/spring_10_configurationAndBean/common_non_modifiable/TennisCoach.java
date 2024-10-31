package com.example.springIntroduction.spring_10_configurationAndBean.common_non_modifiable;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class TennisCoach implements Coach {
    public TennisCoach() {
        System.out.println(STR."In constructor: \{getClass().getSimpleName()}");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }
}
