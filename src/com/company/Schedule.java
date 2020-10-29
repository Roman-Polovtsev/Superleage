package com.company;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;


public class Schedule {

    private final Team home;
    private final Team guest;
    private LocalDateTime gameTime;
    private Address gameAddress;
    private Result gameResult;

    public  Schedule (){
        this(new Team(), new Team());
    }

    public Schedule(Team home, Team guest) {
        this.home = home;
        this.guest = guest;
     //   this.gameAddress = home.getHall().getAddress();
     //   this.gameResult = new Result();
     //  this.gameTime = home.getHall().getGameTime().;
    }

    public Address getGameAddress() {
        return gameAddress;
    }

    public Team getHome() {
        return home;
    }

    public Team getGuest() {
        return guest;
    }

    public Result getGameResult() {
        return gameResult;
    }

    public void setGameResult (int homeScore, int guestScore ){
       this.gameResult = new Result((byte)homeScore, (byte)guestScore);
    }

    public void setGameAddress (Address address){
        this.gameAddress = address;
    }

    // public void setGameTime() {
    //    EnableGameTime gameTime1 =  home.getHall().getGameTime() ;
    //    int iterator = 0;
    //    DayOfWeek[] days = new DayOfWeek[7];
    //     LocalDate dateTemp = LocalDate.now();

    //    while(!gameTime1.getDays().isEmpty()) {
    //        days[iterator] = gameTime1.getDays().get(iterator);
    //        iterator++;
    //    }
    //     DayOfWeek day_compare = dateTemp.plusDays(0).getDayOfWeek();
    //    while ( days.length > 1 ) {
    //        if (dateTemp.getDayOfWeek().equals(days[1]))
    //            break;
    //        else
    //            dateTemp.plusDays(1);
    //    }

    //     this.gameTime = LocalDateTime.of(dateTemp,gameTime1.getBegin());
    // }

    public void setGameTime ( LocalDateTime dateTemp, DayOfWeek day ){
        this.gameTime = dateTemp.with(TemporalAdjusters.nextOrSame(day));
    }

    public LocalDateTime getGameTime(){
        return gameTime;
    }



    @Override
    public String toString() {
        return "Game between \"" + home.getName() +"\" and \"" + guest.getName() + "\" is held \n" + gameTime.getDayOfWeek() +
                " " + gameTime.getDayOfMonth() + " " + gameTime.getMonth()+ " at " + gameTime.getHour() + " a.m.\nin " +
                gameAddress + "\n\tGame result: " + gameResult;
    }


}
