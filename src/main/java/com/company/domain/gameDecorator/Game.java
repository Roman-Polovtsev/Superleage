package com.company.domain.gameDecorator;

import com.company.domain.Address;
import com.company.domain.IdHolders;
import com.company.domain.Team;

import java.io.Serializable;
import java.time.LocalDateTime;

public interface Game extends Serializable, IdHolders {

    long getID();

    Team getHome();

    Team getGuest();

    Address getGameAddress();

    LocalDateTime getGameTime();
}
