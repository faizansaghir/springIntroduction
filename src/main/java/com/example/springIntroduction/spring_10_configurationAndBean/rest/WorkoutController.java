package com.example.springIntroduction.spring_10_configurationAndBean.rest;

import com.example.springIntroduction.spring_10_configurationAndBean.common_non_modifiable.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkoutController {

    private Coach coach;
    @Autowired
    public WorkoutController(@Qualifier("cricketCoach") Coach coach)
    {
        System.out.println(STR."In constructor: \{getClass().getSimpleName()}");
        this.coach = coach;
    }

    @GetMapping("/daily-workout")
    public String getDailyWorkout(){
        return coach.getDailyWorkout();
    }

}
