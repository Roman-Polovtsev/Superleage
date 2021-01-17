package com.company.domain.PlayerDecorator;

import com.company.domain.FinishedGame;
import com.company.domain.Game;
import com.company.domain.Result;
import com.company.domain.StartedGame;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class RefereeTest {
    static AbstractPerson person = new ConcretePerson("Ivan", 1995);
    static AbstractPerson player = new Player(person, 190, "not stated", "not stated");
    static Referee referee = new Referee(person);
    static Game game = new FinishedGame();


    @Before
    public void beforeSetup() {
        referee.addGame(game, 5, 5);
    }

    @After
    public void clean() {
        referee.deleteGame(game);
    }

    @Test
    public void addGame() {
        referee.addGame(new FinishedGame(), 4, 4);

        assertEquals(referee.getGames().size(), 2);
        assertFalse(referee.getGames().isEmpty());
    }

    @Test
    public void addGameArray() {
        referee.addGame(game,new int[]{5,5});

        assertEquals(2,referee.getGames().size() );
        assertFalse(referee.getGames().isEmpty());
    }

    @Test
    public void deleteGame() {
        referee.deleteGame(game);

        assertFalse(referee.getGames().isEmpty());
        assertFalse(referee.getGames().contains(game));
        assertEquals(1, referee.getGames().size());
    }

    @Test
    public void getName() {
        String actual = referee.getName();

        assertEquals("Ivan", actual);
    }

    @Test
    public void getYear() {
        int actual = referee.getYearOfBirth();

        assertEquals(1995, actual);

    }

    @Test
    public void average() {
        referee.addGame(game, 5, 5);

        float averageMark = referee.getAverageMark();
        Set<Game> games = referee.getGames();

        assertEquals(4.5, averageMark, 0.01);
        assertFalse(games.isEmpty());
        assertEquals(2, games.size());
    }
}