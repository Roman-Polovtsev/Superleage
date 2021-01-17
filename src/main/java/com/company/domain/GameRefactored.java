package com.company.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.company.domain.PlayerDecorator.Referee;

import java.util.Arrays;
import java.util.Objects;

public class GameRefactored {
    private final Logger logger;
    private final Team homeTeam;
    private final Team guestTeam;
    private final Result result;
    private final Referee referee;
    private final int[] refMarks;
    private final Address gameAddress;


    public GameRefactored() {
        this(new Team("home"), new Team("guest"), LoggerFactory.getLogger(GameRefactored.class));
    }

    public GameRefactored(Team homeTeam, Team guestTeam, Logger logger) {
        this(homeTeam, guestTeam, homeTeam.getHall().getAddress(), logger);
    }

    public GameRefactored(Team homeTeam, Team guestTeam, Address gameAddress, Logger logger) {
        this(homeTeam, guestTeam, null, null, null, gameAddress, logger);
    }

    public GameRefactored(Team homeTeam, Team guestTeam, Result result, Referee referee, int[] refMarks, Address gameAddress, Logger logger) {
        this.homeTeam = homeTeam;
        this.guestTeam = guestTeam;
        this.result = result;
        this.referee = referee;
        this.refMarks = refMarks;
        this.gameAddress = gameAddress;
        this.logger = logger;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getGuestTeam() {
        return guestTeam;
    }

    public Result getResult() {
        return result;
    }

    public Referee getReferee() throws NullPointerException {
        if (this.referee == null)
            throw new NullPointerException(this.toString());
        return referee;
    }

    public int[] getRefMarks() {
        return refMarks;
    }

    public Address getGameAddress() {
        return gameAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameRefactored that = (GameRefactored) o;
        return Objects.equals(homeTeam, that.homeTeam) &&
                Objects.equals(guestTeam, that.guestTeam) &&
                Objects.equals(result, that.result) &&
                Objects.equals(referee, that.referee) &&
                Arrays.equals(refMarks, that.refMarks) &&
                Objects.equals(gameAddress, that.gameAddress);
    }

    @Override
    public int hashCode() {
        int result1 = Objects.hash(homeTeam, guestTeam, result, referee, gameAddress);
        result1 = 31 * result1 + Arrays.hashCode(refMarks);
        return result1;
    }
}
