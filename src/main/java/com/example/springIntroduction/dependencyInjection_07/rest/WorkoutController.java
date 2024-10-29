package com.example.springIntroduction.dependencyInjection_07.rest;

import com.example.springIntroduction.dependencyInjection_07.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Lazy
public class WorkoutController {
    private Coach coach;

    @Autowired
    public WorkoutController(Coach coach)
    {
        System.out.println(STR."In constructor: \{getClass().getSimpleName()}");
        this.coach = coach;
    }

    @GetMapping("/daily-workout")
    public String getDailyWorkout(){
        return this.coach.getDailyWorkout();
    }

}
