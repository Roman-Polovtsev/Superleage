package com.company.domain.gameDecorator;

import com.company.domain.Address;
import com.company.domain.playerDecorator.DefinedPerson;
import com.company.domain.playerDecorator.Referee;
import com.company.domain.Result;
import com.company.domain.Team;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

public class FinishedGame extends GameDecorator {
    transient private static final long serialVersionUID = 13L;
    private static long idCounter = 1;
    private final long id;
    private final Result result;
    private final Referee referee;
    private final int[] refereeMarks;

    public FinishedGame(Game game) {
        this(game, new Result(), new Referee(new DefinedPerson()), new int[]{0, 0});
    }

    public FinishedGame(Game game, Result result, Referee referee, int[] refereeMarks) {
        super(game);
        this.id = game.getID();
        this.result = result;
        this.referee = referee;
        this.refereeMarks = refereeMarks;
        referee.addGame(this);
        idCounter++;
    }

    @Override
    public long getID() {
        return this.id;
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
        return "FinishedGame{" +
                "result=" + result +
                ", referee=" + referee.getName() +
                ", refereeMarks=" + Arrays.toString(refereeMarks) +
                ", game=" + game +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FinishedGame that = (FinishedGame) o;
        return id == that.id &&
                Objects.equals(result, that.result) &&
                Arrays.equals(refereeMarks, that.refereeMarks);
    }

    @Override
    public int hashCode() {
        int result1 = Objects.hash(super.hashCode(), id, result);
        result1 = 31 * result1 + Arrays.hashCode(refereeMarks);
        return result1;
    }
}
