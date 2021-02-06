package com.company.repository.hibernate;

import com.company.domain.playerDecorator.DefinedPerson;
import com.company.repository.DataBaseException;
import com.company.repository.player.PersonRepository;
import com.company.util.FileReadException;

import javax.persistence.EntityManager;
import java.util.List;

public class HbPersonRepository implements PersonRepository {
    private EntityManager entityManager;

    public HbPersonRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(DefinedPerson person) throws DataBaseException {

    }

    @Override
    public void remove(DefinedPerson player) throws DataBaseException {

    }

    @Override
    public DefinedPerson findById(long personId) throws FileReadException, DataBaseException {
        return null;
    }

    @Override
    public List<DefinedPerson> findAll() throws FileReadException, DataBaseException {
        return null;
    }
}
