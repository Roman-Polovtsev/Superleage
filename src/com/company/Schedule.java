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
     this.gameAddress = Main.getHallAddr(home.getHall());
     //this.gameTime    = home.getHall().getGameTime();
     this.gameResult = Main.getGameResult(this);
   }

   public Team getHome (Schedule schedule){
       return home;
   }

   public Team getGuest (Schedule schedule){
       return guest;
   }

   public Result getGameResult (){
       return gameResult;
   }


   public void setResult (byte home, byte guest){
       for (Result i: re
            ) {
           
       }
       Main.addGameResult()
   };


}
