package com.company.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RefereeTest {

    @Test
    public void averageMarkTestThrow() {

    }

    @Test
    public void addGame() {
        Referee referee = new Referee();
        FinishedGame game = new FinishedGame();

        referee.addGame(game);

        assertTrue(referee.getGames().contains(game));
        assertEquals(1, referee.getGames().size());
        System.out.println(game);
        System.out.println(referee);
    }

    @Test
    public void getGames() {
    }

    @Test
    public void getMarks() {
    }

    @Test
    public void averageMark() {
    }
}