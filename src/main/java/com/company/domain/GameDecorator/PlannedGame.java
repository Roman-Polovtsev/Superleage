package com.company.domain.GameDecorator;

import com.company.domain.Address;
import com.company.domain.IdHolders;
import com.company.domain.Team;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * This  class is game decorator
 */
public class PlannedGame implements Game, IdHolders {
    transient private static final long serialVersionUID = 12L;
    private static final LocalDateTime defaultTime = LocalDateTime.of(2020, 1, 1, 0, 0);
    private static long idCounter = 1;
    private final long ID;
    private final Team home;
    private final Team guest;
    private final Address gameAddress;
    private final LocalDateTime gameTime;

    public PlannedGame(Team home, Team guest, Address gameAddress, LocalDateTime gameTime) {
        this.home = home;
        this.guest = guest;
        this.gameAddress = gameAddress;
        this.gameTime = gameTime;
        this.ID = idCounter;
        idCounter++;
    }

    public PlannedGame() {
        this(new Team(), new Team(), new Team().getHall().getAddress(), defaultTime);
    }

    public PlannedGame(Team home, Team guest) {
        this(home, guest, home.getHall().getAddress(), defaultTime);
    }

    public PlannedGame (Game game, Address address){
        this.home = game.getHome();
        this.guest = game.getGuest();
        this.gameTime =game.getGameTime();
        this.gameAddress =address;
        this.ID = game.getID();
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
                Objects.equals(home, that.home) &&
                Objects.equals(guest, that.guest) &&
                Objects.equals(gameAddress, that.gameAddress) &&
                Objects.equals(gameTime, that.gameTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, home, guest, gameAddress, gameTime);
    }
}
