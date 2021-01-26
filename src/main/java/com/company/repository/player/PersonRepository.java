package com.company.repository.player;

import com.company.domain.PlayerDecorator.AbstractPerson;
import com.company.domain.PlayerDecorator.DefinedPerson;
import com.company.domain.PlayerDecorator.Player;
import com.company.util.FileReadException;

import java.util.List;

public interface PersonRepository {
    void save(DefinedPerson person) throws Exception;

    void remove(Player player) throws Exception;

    Player findById(long personId) throws FileReadException;

    List<Player> findAll() throws FileReadException;
}
