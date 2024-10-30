package com.example.springIntroduction.dependencyInjection_08.rest;

import com.example.springIntroduction.dependencyInjection_08.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkoutController {

    private Coach cricketCoach1;
    private Coach cricketCoach2;

    private Coach tennisCoach1;
    private Coach tennisCoach2;

    @Autowired
    public WorkoutController(
            @Qualifier("cricketCoach") Coach cricketCoach1,
            @Qualifier("cricketCoach") Coach cricketCoach2,
            @Qualifier("tennisCoach") Coach tennisCoach1,
            @Qualifier("tennisCoach") Coach tennisCoach2)
    {
        System.out.println(STR."In constructor: \{getClass().getSimpleName()}");
        this.cricketCoach1 = cricketCoach1;
        this.cricketCoach2 = cricketCoach2;
        this.tennisCoach1 = tennisCoach1;
        this.tennisCoach2 = tennisCoach2;
    }

    @GetMapping("/check-instance-equality")
    public String checkInstanceEquality(){
        String s1 = STR."Cricket coach 1 is same as Cricket coach 2: \{cricketCoach1 == cricketCoach2}";
        String s2 = STR."Tennis coach 1 is same as Tennis coach 2: \{tennisCoach1 == tennisCoach2}";
        return STR."[\{s1},\{s2}]";
    }

}
