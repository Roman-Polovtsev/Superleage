package com.company.domain;

import java.time.LocalDateTime;

public interface Game {

    Team getHome();

    Team getGuest();

    Address getGameAddress();

    Result getGameResult();

    Referee getGameReferee();

    int[] getRefereeMarks();

    LocalDateTime getGameTime();

}
