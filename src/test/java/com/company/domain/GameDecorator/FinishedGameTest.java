package com.company.domain.GameDecorator;

import com.company.domain.PlayerDecorator.DefinedPerson;
import com.company.domain.PlayerDecorator.Referee;
import com.company.domain.Result;
import com.company.domain.Team;
import org.junit.Test;

public class FinishedGameTest {
    Team home = new Team("home");
    Team guest = new Team("guest");
    Referee referee = new Referee(new DefinedPerson("Dredd",2000,1));
    PlannedGame gamePlanned = new PlannedGame(home,guest);
    FinishedGame game = new FinishedGame(gamePlanned,new Result(),referee,new int[]{5,5});

    @Test
    public void getGameResult() {
        Result gameResult = game.getGameResult();


    }

    @Test
    public void getGameReferee() {
    }

    @Test
    public void getRefereeMarks() {
    }
}