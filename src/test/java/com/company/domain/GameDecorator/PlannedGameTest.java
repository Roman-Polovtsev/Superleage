package com.company.domain.GameDecorator;

import com.company.domain.Team;
import org.junit.Test;
import org.w3c.dom.ls.LSOutput;

import static org.junit.Assert.*;

public class PlannedGameTest {
    Team home = new Team();
    Team guest = new Team("guest");
    Game game = new PlannedGame(home,guest);



    @Test
    public void getHome() {

    }

    @Test
    public void getGuest() {
    }

    @Test
    public void getGameAddress() {
    }

    @Test
    public void getGameResult() {
    }

    @Test
    public void getGameReferee() {
    }

    @Test
    public void getRefereeMarks() {
    }

    @Test
    public void getGameTime() {
    }
}