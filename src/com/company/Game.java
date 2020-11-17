package com.company;

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
