package com.company.domain.GameDecorator;

import com.company.domain.PlayerDecorator.ConcretePerson;
import com.company.domain.PlayerDecorator.Referee;
import com.company.domain.Result;
import com.company.domain.Team;
import org.junit.Test;

import static org.junit.Assert.*;

public class FinishedGameTest {
    Team home = new Team("home");
    Team guest = new Team("guest");
    Referee referee = new Referee(new ConcretePerson("Dredd",2000));
    PlannedGame gamePlanned = new PlannedGame(home,guest,1);
    FinishedGame game = new FinishedGame(gamePlanned,new Result(),referee,new int[]{5,5});

    @Test
    public void getGameResult() {
    }

    @Test
    public void getGameReferee() {
    }

    @Test
    public void getRefereeMarks() {
    }
}