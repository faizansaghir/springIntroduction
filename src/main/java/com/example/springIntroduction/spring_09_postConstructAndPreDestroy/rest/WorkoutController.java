package com.example.springIntroduction.spring_09_postConstructAndPreDestroy.rest;

import com.example.springIntroduction.spring_09_postConstructAndPreDestroy.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkoutController {

    private Coach coach;
    @Autowired
    public WorkoutController(
            @Qualifier("cricketCoach") Coach coach)
    {
        System.out.println(STR."In constructor: \{getClass().getSimpleName()}");
        this.coach = coach;
    }

    @GetMapping("/daily-workout")
    public String getDailyWorkout(){
        return coach.getDailyWorkout();
    }

}
