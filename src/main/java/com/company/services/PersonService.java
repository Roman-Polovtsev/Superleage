package com.company.services;

import com.company.domain.Person;
import com.company.repository.person.FilePersonRepository;
import com.company.repository.person.PersonRepository;

public class PersonService {

    private PersonRepository repository = new FilePersonRepository();

    public void distributeStudents() {
        Person first = new Person();
        Person second = new Person();
        Person third = new Person();

        repository.save(first);
        repository.save(second);
        repository.save(third);
    }


}
