package com.example.springIntroduction.dependencyInjection_06.rest;

import com.example.springIntroduction.dependencyInjection_06.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkoutController {
    private Coach coach;

    @Autowired
    public WorkoutController(Coach coach)
    {
        this.coach = coach;
    }

    @GetMapping("/daily-workout")
    public String getDailyWorkout(){
        return this.coach.getDailyWorkout();
    }

}
