//package com.company;
//
//import java.time.LocalDateTime;
//
//public class Schedule {
//    private Team home;
//    private Team guest;
//    private LocalDateTime gameTime;
//    private Address gameAddress;
//    private Result gameResult;
//
//    //creating constructor
//    Schedule (Team home, Team guest ){
//      this.home = home;
//      this.guest = guest;
//      this.gameAddress = home.getHall().getAddress();
//      this.gameTime    = home.getHall().getGameTime();
//      this.gameResult = gameResult.getResult();
//    }
//
//    public void setResult(Team home, Team guest, byte homeScore, byte guestScore){
//        Result homeGuest = new Result ( homeScore, guestScore);
//    }
//
////    void lookAtResult (Team home, Team guest) {
////        System.out.println("Результат игры команды " + home.getName() + " и команды "+ guest.getName() +":"+ gameResult.show() );
////    }
////
////    void lookAtHall (Address gameAddress, LocalDateTime gameTime) {
////        System.out.println("Игра проводилась в городе" + gameAddress.getCity() + "по адресу "+ gameAddress.getStreet() +"дом"+ gameAddress.getBuildingNumber() );
////    }
//
//}
