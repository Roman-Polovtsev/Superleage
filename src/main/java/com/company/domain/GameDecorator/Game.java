package com.company.domain.GameDecorator;

import com.company.domain.Address;
import com.company.domain.Referee;
import com.company.domain.Result;
import com.company.domain.Team;

import java.time.LocalDateTime;

public interface Game {

    long getID();

    Team getHome();

    Team getGuest();

    Address getGameAddress();

    LocalDateTime getGameTime();
}
