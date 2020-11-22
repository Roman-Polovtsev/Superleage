package com.company.domain;

import java.util.Objects;

public class Result {
    private final byte homeTeam;
    private final byte guestTeam;

    //making constructor
    public Result() {
        this((byte) 0, (byte) 0);
    }

    public Result(byte homeTeam, byte guestTeam) {
        this.homeTeam = homeTeam;
        this.guestTeam = guestTeam;
    }

    public Result incrementGuestPoint() {
        return new Result(homeTeam, (byte) (guestTeam + 1));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return homeTeam == result.homeTeam &&
                guestTeam == result.guestTeam;
    }

    @Override
    public int hashCode() {
        return Objects.hash(homeTeam, guestTeam);
    }

    @Override
    public String toString() {
        return "Result" +
                " " + homeTeam +
                ":" + guestTeam;
    }

    public byte getHomeScore() {
        return homeTeam;
    }

    public byte getGuestScore() {
        return guestTeam;
    }

}
