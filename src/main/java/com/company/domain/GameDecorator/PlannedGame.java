package com.company.domain.GameDecorator;

import com.company.domain.Address;
import com.company.domain.Referee;
import com.company.domain.Result;
import com.company.domain.Team;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * This  class is game decorator
 */
public class PlannedGame implements Game{
    private Game game;
    private final long ID;
    private final Team home;
    private final Team guest;
    private final Address gameAddress;
    private final LocalDateTime gameTime;
    private static final LocalDateTime defaultTime = LocalDateTime.of(2020,1,1,0,0);

    public PlannedGame(Team home, Team guest, Address gameAddress, LocalDateTime gameTime, long ID) {
        this.home = home;
        this.guest = guest;
        this.gameAddress = gameAddress;
        this.gameTime = gameTime;
        this.ID = ID;
    }


    public PlannedGame() {
        this(new Team(),new Team(),new Team().getHall().getAddress(), defaultTime,1);
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlannedGame that = (PlannedGame) o;
        return ID == that.ID &&
                Objects.equals(game, that.game) &&
                Objects.equals(home, that.home) &&
                Objects.equals(guest, that.guest) &&
                Objects.equals(gameAddress, that.gameAddress) &&
                Objects.equals(gameTime, that.gameTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(game, ID, home, guest, gameAddress, gameTime);
    }
}
