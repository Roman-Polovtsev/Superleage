package com.company;

import java.time.LocalDateTime;

public class Schedule {
    Team home;
    Team guest;
    LocalDateTime gameTime;
    Address gameAddress;
    Result gameResult;

    void lookAtResult (Team home, Team guest) {
        System.out.println("Результат игры команды " + " и команды "+":"+ home,guest,gameResult.show() );
    }

}
