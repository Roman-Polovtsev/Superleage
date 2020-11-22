package com.company.domain;

import java.time.LocalDateTime;
import java.util.Arrays;

public class FinishedGame implements Game {

    private final Game startedGame;
    private final Result gameResult;
    private final Referee gameReferee;
    private final int[] refereeMarks;
    private final LocalDateTime gameTime;

    public FinishedGame(Game startedGame, Result gameResult, Referee gameReferee, int[] refereeMarks, LocalDateTime gameTime) {
        this.startedGame = startedGame;
        this.gameResult = gameResult;
        this.gameReferee = gameReferee;
        this.refereeMarks = refereeMarks;
        this.gameTime = gameTime;
    }

    @Override
    public Team getHome() {
        return startedGame.getHome();
    }

    @Override
    public Team getGuest() {
        return startedGame.getGuest();
    }

    @Override
    public Address getGameAddress() {
        return startedGame.getGameAddress();
    }

    @Override
    public Result getGameResult() {
        return gameResult;
    }

    @Override
    public Referee getGameReferee() {
        return gameReferee;
    }

    @Override
    public int[] getRefereeMarks() {
        return refereeMarks;
    }

    @Override
    public LocalDateTime getGameTime() {
        return gameTime;
    }

    @Override
    public String toString() {
        return "FinishedGame{" +
                "startedGame=" + startedGame +
                ", gameResult=" + gameResult +
                ", gameReferee=" + gameReferee +
                ", refereeMarks=" + Arrays.toString(refereeMarks) +
                ", gameTime=" + gameTime +
                '}';
    }
}
