package com.company.domain.PlayerDecorator;

import com.company.domain.GameDecorator.FinishedGame;
import com.company.domain.GameDecorator.PlannedGame;
import com.company.domain.Result;
import com.company.domain.Team;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerDecoratorRefereeTest {
    Referee referee = new Referee(new DefinedPerson("Ivan", 1995));
    FinishedGame game1 = new FinishedGame(new PlannedGame(), new Result(), referee, new int[]{2, 2});
    FinishedGame game2 = new FinishedGame(new PlannedGame(new Team(1), new Team(2), 2), new Result(), referee, new int[]{4, 4});

    @Before
    public void before() {

    }

    @Test
    public void getAverageMark() {
        float actual = referee.getAverageMark();

        assertEquals(3.0, actual, 0.01);
    }
}