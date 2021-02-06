package com.company.repository.player;

import com.company.domain.playerDecorator.DefinedPerson;
import com.company.repository.DataBaseException;
import com.company.util.FileReadException;

import java.util.List;

public interface PersonRepository {
    void save(DefinedPerson person) throws DataBaseException;

    void remove(DefinedPerson player) throws DataBaseException;

    DefinedPerson findById(long personId) throws FileReadException, DataBaseException;

    List<DefinedPerson> findAll() throws FileReadException, DataBaseException;
}
