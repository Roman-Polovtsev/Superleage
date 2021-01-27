package com.company.repository.player;

import com.company.domain.PlayerDecorator.AbstractPerson;
import com.company.domain.PlayerDecorator.DefinedPerson;
import com.company.domain.PlayerDecorator.Player;
import com.company.util.FileReadException;

import java.sql.SQLException;
import java.util.List;

public interface PersonRepository {
    void save(DefinedPerson person) throws Exception;

    void remove(DefinedPerson player) throws Exception;

    DefinedPerson findById(long personId) throws FileReadException, SQLException;

    List<DefinedPerson> findAll() throws FileReadException, SQLException;
}
