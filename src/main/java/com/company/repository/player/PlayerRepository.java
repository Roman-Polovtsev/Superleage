package com.company.repository.player;

import com.company.domain.PlayerDecorator.Player;
import com.company.util.FileReadException;

import java.util.List;

public interface PlayerRepository {
    void save(Player player) throws Exception;

    void remove(Player player) throws Exception;

    Player findById(long personId) throws FileReadException;

    List<Player> findAll() throws FileReadException;
}
