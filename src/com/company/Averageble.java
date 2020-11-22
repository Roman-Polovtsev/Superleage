package com.company;

public interface Averageble {

    float average();
    default float averageNew(){
        return 0;
    }
}
