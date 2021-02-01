package com.company.domain.PlayerDecorator;


import com.company.domain.GameDecorator.FinishedGame;
import com.company.domain.GameDecorator.PlannedGame;
import com.company.domain.Result;
import com.company.domain.Team;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class RefereeTest {
    static Person person = new DefinedPerson("Ivan", 1995, 1);
    static Person player = new Player(person, 190, "not stated", "not stated", person.getID());
    static Referee referee = new Referee(person);
    static Team home = new Team("home");
    static Team guest = new Team("guest");
    static FinishedGame game = new FinishedGame(new PlannedGame(home, guest), new Result(), referee, new int[]{5, 5});
    private final FinishedGame anotherGame = new FinishedGame(new PlannedGame(), new Result(), referee, new int[]{4, 4});

    @Before
    public void beforeSetup() {
        referee.addGame(game);
    }

    @After
    public void clean() {
        referee.deleteAllGames();
    }

    @Test
    public void creatingGame() {
        FinishedGame testGame = new FinishedGame(new PlannedGame(home, guest), new Result(), referee, new int[]{3, 3});

        Set<FinishedGame> games = referee.getGames();
        System.out.println(games);

        assertTrue(games.contains(testGame));
        assertEquals(3, games.size());
        assertEquals(4, referee.getAverageMark(), 0.1);

    }

    @Test
    public void addGame() {
        referee.addGame(anotherGame);

        Set<FinishedGame> games = referee.getGames();

        assertEquals(2, games.size());
        assertFalse(games.isEmpty());
        assertTrue(games.contains(anotherGame));
    }

    @Test
    public void addGameArray() {
        FinishedGame finishedGame = new FinishedGame(new PlannedGame(new Team("a"), new Team("b")));
        referee.addGame(finishedGame, anotherGame);

        assertEquals(3, referee.getGames().size());
        assertFalse(referee.getGames().isEmpty());
        assertTrue(referee.getGames().contains(finishedGame));
        assertTrue(referee.getGames().contains(anotherGame));

    }

    @Test
    public void deleteGame() {
        referee.deleteGame(game);

        Set<FinishedGame> games = referee.getGames();

        assertFalse(games.isEmpty());
        assertFalse(games.contains(game));
        assertEquals(1, games.size());
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
        referee.addGame(anotherGame);

        float averageMark = referee.getAverageMark();
        Set<FinishedGame> games = referee.getGames();

        assertEquals(4.5, averageMark, 0.01);
        assertFalse(games.isEmpty());
        assertEquals(2, games.size());
    }
}