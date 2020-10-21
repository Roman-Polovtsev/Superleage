package com.company;

import java.time.LocalDateTime;

public class Schedule {
    Team home;
    Team guest;
    LocalDateTime gameTime;
    Address gameAddress;
    Result gameResult;

    void lookAtResult (Team home, Team guest) {
        System.out.println("Результат игры команды " + home.name + " и команды "+ guest.name +":"+ gameResult.show() );
    }

    void lookAtHall (Address gameAddress, LocalDateTime gameTime) {
        System.out.println("Игра проводилась в городе" + gameAddress.city + "по адресу "+ gameAddress.street +"дом"+ gameAddress.buildingNumber );
    }

}
