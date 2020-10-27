package com.company;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;


public class Schedule {
    private static Set<Schedule> scheduleSet = new HashSet<Schedule>();

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
        this.gameAddress = home.getHall().getAddress();
        this.gameResult = new Result();
     //   this.gameTime = home.getHall().getGameTime().;
    }


    public static Schedule getSchedule(Team home, Team guest) {
        Schedule currentSchedule = null;
        for (Schedule item : scheduleSet)
            if ((item.home.equals(home)) && (item.guest.equals(guest))) {
                currentSchedule = item;
                break;
            }
        return currentSchedule;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Schedule schedule = (Schedule) o;
//        return Objects.equals(home, schedule.home) &&
//                Objects.equals(guest, schedule.guest) &&
//                Objects.equals(gameTime, schedule.gameTime) &&
//                Objects.equals(gameAddress, schedule.gameAddress) &&
//                Objects.equals(gameResult, schedule.gameResult);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(home, guest, gameTime, gameAddress, gameResult);
//    }

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

    public void setGameTime() {
       EnableGameTime gameTime1 =  home.getHall().getGameTime() ;
       int iterator = 0;
       DayOfWeek[] days = new DayOfWeek[7];
        LocalDate dateTemp = LocalDate.now();

       while(!gameTime1.getDays().isEmpty()) {
           days[iterator] = gameTime1.getDays().get(iterator);
           iterator++;
       }
        DayOfWeek day_compare = dateTemp.plusDays(0).getDayOfWeek();
       while ( days.length > 1 ) {
           if (dateTemp.getDayOfWeek().equals(days[1]))
               break;
           else
               dateTemp.plusDays(1);
       }

        this.gameTime = LocalDateTime.of(dateTemp,gameTime1.getBegin());
    }

    @Override
    public String toString() {
        return "Game between \"" + home.getName() +"\" and \"" + guest.getName() + "\" is held " + gameTime.getDayOfWeek() +
                "\n\t" + gameResult;
    }


}
