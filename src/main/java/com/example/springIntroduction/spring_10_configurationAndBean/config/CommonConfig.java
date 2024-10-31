package com.example.springIntroduction.spring_10_configurationAndBean.config;

import com.example.springIntroduction.spring_10_configurationAndBean.common_non_modifiable.Coach;
import com.example.springIntroduction.spring_10_configurationAndBean.common_non_modifiable.CricketCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfig {

    @Bean
    public Coach cricketCoach(){
        return new CricketCoach();
    }

}
