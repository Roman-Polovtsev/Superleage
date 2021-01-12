package com.company.domain.GameDecorator;

import com.company.domain.Address;
import com.company.domain.Referee;
import com.company.domain.Result;
import com.company.domain.Team;

import java.time.LocalDateTime;

/**
 * This  class is game decorator
 */
public class PlannedGame implements Game{
    private Game game;
    private final long ID;
    private final Team home;
    private final Team guest;
    private final Address gameAddress;
    private LocalDateTime gameTime;
    private static final LocalDateTime defaultTime = LocalDateTime.of(2020,1,1,0,0);

    public PlannedGame(Team home, Team guest, Address gameAddress, LocalDateTime gameTime, long ID) {
        this.home = home;
        this.guest = guest;
        this.gameAddress = gameAddress;
        this.gameTime = gameTime;
        this.ID = ID;
    }

    public PlannedGame(Game game,Team home, Team guest, long ID) {
        this.game = game;
        this.home = home;
        this.guest = guest;
        this.gameAddress = home.getHall().getAddress();
        this.ID = ID;
    }

//    public PlannedGame() {
//        this(new Team(),new Team(),new Team().getHall().getAddress(), defaultTime,);
//    }

    public PlannedGame(Team home, Team guest, long ID) {
        this(home,guest,home.getHall().getAddress(),defaultTime,ID);
    }

    @Override
    public long getID() {
        return this.ID;
    }

    @Override
    public Team getHome() {
        return this.home;
    }

    @Override
    public Team getGuest() {
        return this.guest;
    }

    @Override
    public Address getGameAddress() {
        return this.gameAddress;
    }

    @Override
    public Result getGameResult() {
        return null;
    }

    @Override
    public Referee getGameReferee() {
        return null;
    }

    @Override
    public int[] getRefereeMarks() {
        return null;
    }

    @Override
    public LocalDateTime getGameTime() {
        return this.gameTime;
    }

    @Override
    public String toString() {
        return "PlannedGame{" +
                "game=" + game +
                ", ID=" + ID +
                ", home=" + home +
                ", guest=" + guest +
                ", gameAddress=" + gameAddress +
                ", gameTime=" + gameTime +
                '}';
    }
}
