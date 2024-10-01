package com.example.springIntroduction.SpringFeature_05;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessCalculationService {
    private final DataService dataService;

    public BusinessCalculationService(DataService dataService) {
        this.dataService = dataService;
    }

    public int getMax(){
        return Arrays.stream(dataService.retrieveData()).max().orElse(0);
    }
}
