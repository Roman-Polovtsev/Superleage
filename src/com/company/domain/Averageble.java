package com.company.domain;

public interface Averageble {

    float average();
    default float averageNew(){
        return 0;
    }
}
