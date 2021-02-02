package com.company.domain.playerDecorator;

import com.company.domain.gameDecorator.FinishedGame;
import com.company.domain.gameDecorator.PlannedGame;
import com.company.domain.Result;
import com.company.domain.Team;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class PlayerDecoratorRefereeTest {
    Referee referee;
    FinishedGame game1;
    FinishedGame game2;

    @Before
    public void before() {
        referee = new Referee(new DefinedPerson("Ivan", 1995, 1));
        game1 = new FinishedGame(new PlannedGame(), new Result(), referee, new int[]{2, 2});
        game2 = new FinishedGame(new PlannedGame(new Team("1"), new Team("2")), new Result(), referee, new int[]{4, 4});

    }

    @Test
    public void getAverageMark() {
        float actual = referee.getAverageMark();

        assertEquals(3.0, actual, 0.01);
    }

    @Test
    public void deleteGame() {
        FinishedGame newGame = new FinishedGame(new PlannedGame(new Team("7"),new Team("6")), new Result(3,1), referee, new int[]{2, 3});

        referee.deleteGame(game1);

        Set<FinishedGame> games = referee.getGames();

        assertTrue(games.contains(newGame));
        assertFalse(games.contains(game1));
    }
}