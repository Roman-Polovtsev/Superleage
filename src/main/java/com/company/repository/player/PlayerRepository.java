package com.company.repository.player;

import com.company.domain.Person;
import com.company.domain.Player;

import java.util.List;

public interface PlayerRepository {
    void save(Player player);

    void remove(Player player);

    Player findById(long personId);

    List<Player> findAll();
}
