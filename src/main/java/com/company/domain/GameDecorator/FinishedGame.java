package com.company.domain.GameDecorator;

import com.company.domain.Address;
import com.company.domain.Referee;
import com.company.domain.Result;
import com.company.domain.Team;

import java.time.LocalDateTime;
import java.util.Arrays;

public class FinishedGame extends PlannedGame {
    Result result;
    Referee referee;
    int [] refereeMarks;

    public FinishedGame(Game game) {
        super(game, game.getHome(), game.getGuest(),game.getID());
    }

    public FinishedGame(Game game, Result result, Referee referee, int[] refereeMarks) {
        super(game, game.getHome(), game.getGuest(),game.getID());
        this.result = result;
        this.referee = referee;
        this.refereeMarks = refereeMarks;
    }

    @Override
    public long getID(){
        return super.getID();
    }

    @Override
    public Team getHome() {
        return super.getHome();
    }

    @Override
    public Team getGuest() {
        return super.getGuest();
    }

    @Override
    public Address getGameAddress() {
        return super.getGameAddress();
    }

    @Override
    public Result getGameResult() {
        return this.result;
    }

    @Override
    public Referee getGameReferee() {
        return this.referee;
    }

    @Override
    public int[] getRefereeMarks() {
        return this.refereeMarks;
    }

    @Override
    public LocalDateTime getGameTime() {
        return super.getGameTime();
    }

    @Override
    public String toString() {
        return "FinishedGame{"+ super.toString()+
                "result=" + result +
                ", referee=" + referee +
                ", refereeMarks=" + Arrays.toString(refereeMarks) +
                '}';
    }
}
