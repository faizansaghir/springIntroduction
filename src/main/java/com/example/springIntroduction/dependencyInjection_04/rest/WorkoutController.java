package com.example.springIntroduction.dependencyInjection_04.rest;

import com.example.springIntroduction.dependencyInjection_04.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkoutController {
    private Coach coach;

    @Autowired
    public void setCoach(Coach coach){
        this.coach=coach;
    }

    @GetMapping("/daily-workout")
    public String getDailyWorkout(){
        return this.coach.getDailyWorkout();
    }
}
