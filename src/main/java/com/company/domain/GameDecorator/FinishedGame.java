package com.company.domain.GameDecorator;

import com.company.domain.Address;

import com.company.domain.PlayerDecorator.DefinedPerson;
import com.company.domain.PlayerDecorator.Referee;
import com.company.domain.Result;
import com.company.domain.Team;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

public class FinishedGame extends GameDecorator {
    transient private static final long serialVersionUID = 13L;
    private final Result result;
    private final Referee referee;
    private final int [] refereeMarks;

    public FinishedGame(Game game) {
        this(game, new Result(),new Referee(new DefinedPerson()),new int[]{0,0});
    }

    public FinishedGame(Game game, Result result, Referee referee, int[] refereeMarks) {
        super(game);
        this.result = result;
        this.referee = referee;
        this.refereeMarks = refereeMarks;
        referee.addGame(this);
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

    public Result getGameResult() {
        return this.result;
    }

    public Referee getGameReferee() {
        return this.referee;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FinishedGame that = (FinishedGame) o;
        return Objects.equals(result, that.result) &&
                Objects.equals(referee, that.referee) &&
                Arrays.equals(refereeMarks, that.refereeMarks);
    }

    @Override
    public int hashCode() {
        int result1 = Objects.hash(super.hashCode(), result, referee);
        result1 = 31 * result1 + Arrays.hashCode(refereeMarks);
        return result1;
    }
}
