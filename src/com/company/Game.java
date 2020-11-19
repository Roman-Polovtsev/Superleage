package com.company;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Game {
    private final Team home;
    private final Team guest;
    private Address gameAddress;
    private Result gameResult;
    private Referee gameReferee;
    private int [] refereeMarks;
    private LocalDateTime gameTime;

    public Game (){
        this(new Team(), new Team());
    }

    public Game (Team home, Team guest){
        this.guest = guest;
        this.home = home;
        this.gameAddress = home.getHall().getAddress();
    }

    public void setGameAddress ( Address newAddress){
        this.gameAddress = newAddress;
    }

    public void setGameResult (Result gameResult, Referee gameReferee, int homeMark, int guestMark) {
        this.gameReferee = gameReferee;
        this.gameResult = gameResult;
        this.refereeMarks = new int[]{homeMark,guestMark};
        gameReferee.addGame(this);
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

    public Team getHome() {
        return home;
    }

    public Team getGuest() {
        return guest;
    }

    public Address getGameAddress() {
        return gameAddress;
    }

    public Result getGameResult() {
        return gameResult;
    }

    public Referee getGameReferee() {
        return gameReferee;
    }

    public int[] getRefereeMarks() {
        return refereeMarks;
    }

    public LocalDateTime getGameTime() {
        return gameTime;
    }
}
