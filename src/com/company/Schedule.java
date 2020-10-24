package com.company;

import java.time.LocalDateTime;

public class Schedule {
   private Team home;
   private Team guest;
   private LocalDateTime gameTime;
   private Address gameAddress;
   private Result gameResult;

   //creating constructor
   public Schedule (Team home, Team guest ){
     this.home = home;
     this.guest = guest;
     this.gameAddress = Main.getHallAddr(Main.getTeamHall);
     Main.addScheduleResultMap( this, Result.getResult( home, guest) );
     //this.gameTime    = home.getHall().getGameTime();
     this.gameResult = gameResult.getResult(home, guest);
   }

   public Team getHome (Schedule schedule){
       return home;
   }

   public Team getGuest (Schedule schedule){
       return guest;
   }

   public Result getResult (Schedule schedule){
       return Main.getScheduleResultMap(schedule);
   }
   
//   public String getScore ( Schedule schedule ){
//       schedule.getResult
//   }
//    void lookAtResult (Team home, Team guest) {
//        System.out.println("Результат игры команды " + home.getName() + " и команды "+ guest.getName() +":"+ gameResult.show() );
//    }
//
//    void lookAtHall (Address gameAddress, LocalDateTime gameTime) {
//        System.out.println("Игра проводилась в городе" + gameAddress.getCity() + "по адресу "+ gameAddress.getStreet() +"дом"+ gameAddress.getBuildingNumber() );
//    }

}
