package com.company.repository.person;

import com.company.domain.Person;

import java.util.List;

public class DbPersonRepository implements PersonRepository{
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
