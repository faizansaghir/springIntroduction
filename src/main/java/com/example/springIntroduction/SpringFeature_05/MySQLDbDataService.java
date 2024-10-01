package com.example.springIntroduction.SpringFeature_05;

import org.springframework.stereotype.Repository;

@Repository
public class MySQLDbDataService implements DataService {
    @Override
    public int[] retrieveData() {
        return new int[]{1, 2, 3, 4, 5};
    }
}
