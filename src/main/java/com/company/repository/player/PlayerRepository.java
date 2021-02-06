package com.company.repository.player;

import com.company.domain.playerDecorator.Player;
import com.company.repository.DataBaseException;
import com.company.repository.Repository;

import java.util.List;

public interface PlayerRepository {
    void save(Player player) throws DataBaseException, Repository.FileRepositoryException;

    void remove(Player player) throws DataBaseException, Repository.FileRepositoryException;

    Player findById(long personId) throws DataBaseException, Repository.FileRepositoryException;

    List<Player> findAll() throws DataBaseException, Repository.FileRepositoryException;
}
