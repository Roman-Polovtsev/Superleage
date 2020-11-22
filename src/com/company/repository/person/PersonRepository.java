package com.company.repository.person;

import com.company.domain.Person;

import java.util.List;


//CRUD - create read update delete
public interface PersonRepository {
    void save(Person person);

    void remove(Person person);

    Person findById(long personId);

    List<Person> findAll();

}
