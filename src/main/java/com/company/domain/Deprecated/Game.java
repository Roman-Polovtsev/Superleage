package com.company.domain.Deprecated;

import com.company.domain.Address;
import com.company.domain.Result;
import com.company.domain.Team;

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
