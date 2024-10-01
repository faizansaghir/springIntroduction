package com.example.springIntroduction.sample_01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BusinessCalculationService {
    private final DataService dataService;

    public BusinessCalculationService(DataService dataService) {
        this.dataService = dataService;
    }

    public int getMax(){
        return Arrays.stream(dataService.retrieveData()).max().orElse(0);
    }
}
