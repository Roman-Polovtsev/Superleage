package com.company;

import java.time.LocalDateTime;

public class Schedule {
    private Team home;
    private Team guest;
    private LocalDateTime gameTime;
    private Address gameAddress;
    private Result gameResult;
    
    //creating constructor
    Schedule (Team home, Team guest ){
      this.home = home;
      this.guest = guest;
      this.gameAddress = home.getAddress();
      this.gameTime    = home.getTime();
      this.gameResult = gameResult.getResult();
    }

    public void setResult(Team home, Team guest, byte homeScore, byte guestScore){
        Result homeGuest = new Result ( homeScore, guestScore);
    } 

    void lookAtResult (Team home, Team guest) {
        System.out.println("Результат игры команды " + home.name + " и команды "+ guest.name +":"+ gameResult.show() );
    }

    void lookAtHall (Address gameAddress, LocalDateTime gameTime) {
        System.out.println("Игра проводилась в городе" + gameAddress.city + "по адресу "+ gameAddress.street +"дом"+ gameAddress.buildingNumber );
    }

}
