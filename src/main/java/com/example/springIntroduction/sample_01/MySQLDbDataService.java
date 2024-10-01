package com.example.springIntroduction.sample_01;

import org.springframework.stereotype.Component;

@Component
public class MySQLDbDataService implements DataService{
    @Override
    public int[] retrieveData() {
        return new int[]{1, 2, 3, 4, 5};
    }
}
