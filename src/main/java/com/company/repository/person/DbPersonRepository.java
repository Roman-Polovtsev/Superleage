package com.company.repository.person;

import com.company.domain.Deprecated.Person;
import com.company.repository.team.FileTeamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class DbPersonRepository implements PersonRepository{

    private static final Logger logger = LoggerFactory.getLogger(FileTeamRepository.class);

    @Override
    public void save(Person person) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Person person) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Person findById(long personId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Person> findAll() {
        throw new UnsupportedOperationException();
    }
}
