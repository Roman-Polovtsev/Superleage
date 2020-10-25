package com.company;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

/* are you ready? Not yet
 Let me know when you`ll have enough time

 ok
 */
public class Schedule {
    private static Set<Schedule> scheduleSet = new HashSet<Schedule>();

    private Team home;
    private Team guest;
    private LocalDateTime gameTime;
    private Address gameAddress;
    private Result gameResult;

    //creating constructor
    public Schedule(){
        this()
    }

    public Schedule(Team home, Team guest) {
        this.home = home;
        this.guest = guest;
//        this.gameAddress = Main.getHallAddr(home.getHall());
        scheduleSet.add(this);
        //this.gameTime    = home.getHall().getGameTime();
        //  this.gameResult = Main.getGameResult(this);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return Objects.equals(home, schedule.home) &&
                Objects.equals(guest, schedule.guest) &&
                Objects.equals(gameTime, schedule.gameTime) &&
                Objects.equals(gameAddress, schedule.gameAddress) &&
                Objects.equals(gameResult, schedule.gameResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(home, guest, gameTime, gameAddress, gameResult);
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

    @Override
    public String toString() {
        return "Home team: {" + home + "} Guest team: {" + guest + "} Game Time: " + gameTime;
    }


//   public void setResult (byte home, byte guest){
//       for (Result i: re
//            ) {
//
//       }
//       Main.addGameResult()
//   };


}
