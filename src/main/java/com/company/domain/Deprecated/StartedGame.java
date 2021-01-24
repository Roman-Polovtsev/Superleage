package com.company.domain.Deprecated;

import com.company.domain.Address;
import com.company.domain.Result;
import com.company.domain.Team;

import java.time.LocalDateTime;

public class StartedGame implements Game {
    private final Team home;
    private final Team guest;
    private final Address gameAddress;

    public StartedGame() {
        this(new Team(), new Team());
    }


    public StartedGame(Team home, Team guest) {
        this.guest = guest;
        this.home = home;
        this.gameAddress = home.getHall().getAddress();
    }


    @Override
    public Team getHome() {
        return home;
    }

    @Override
    public Team getGuest() {
        return guest;
    }

    @Override
    public Address getGameAddress() {
        return gameAddress;
    }

    @Override
    public Result getGameResult() {
        throw new UnsupportedOperationException("getGameResult hasn't realization");
    }

    @Override
    public Referee getGameReferee() {
        throw new UnsupportedOperationException("getGameReferee hasn't realization");

    }

    @Override
    public int[] getRefereeMarks() {
        throw new UnsupportedOperationException("getRefereeMarks hasn't realization");

    }

    @Override
    public LocalDateTime getGameTime() {
        throw new UnsupportedOperationException("getGameTime hasn't realization");
    }

    @Override
    public String toString() {
        return "Game between \"" + home.getName() + "\" and \"" + guest.getName() + "\" is held ";
    }
}
