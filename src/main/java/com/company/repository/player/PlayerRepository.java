package com.company.repository.player;

import com.company.domain.PlayerDecorator.Player;
import com.company.repository.DataBaseException;
import com.company.util.FileReadException;

import java.util.List;

public interface PlayerRepository {
    void save(Player player) throws DataBaseException;

    void remove(Player player) throws DataBaseException;

    Player findById(long personId) throws FileReadException, DataBaseException;

    List<Player> findAll() throws FileReadException, DataBaseException;
}
