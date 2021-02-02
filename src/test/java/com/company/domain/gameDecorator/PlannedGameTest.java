package com.company.domain.gameDecorator;

import com.company.domain.Team;
import org.junit.Test;

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