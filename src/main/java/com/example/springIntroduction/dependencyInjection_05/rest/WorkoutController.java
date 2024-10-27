package com.example.springIntroduction.dependencyInjection_05.rest;

import com.example.springIntroduction.dependencyInjection_05.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkoutController {
    private Coach coach;
    private Coach baseballCoach;

    @Autowired
    public WorkoutController(@Qualifier("cricketTrainer") Coach coach, @Qualifier("baseballCoach") Coach baseballCoach)
    {
        this.coach = coach;
        this.baseballCoach = baseballCoach;
    }

    @GetMapping("/daily-workout")
    public String getDailyWorkout(){
        return this.coach.getDailyWorkout();
    }

    @GetMapping("/baseball-daily-workout")
    public String getBaseballDailyWorkout(){
        return this.baseballCoach.getDailyWorkout();
    }
}
