package com.company.services;

import com.company.domain.Person;
import com.company.repository.person.FilePersonRepository;
import com.company.repository.person.PersonRepository;

import java.time.Year;
import java.util.List;
import java.util.stream.Collectors;

public class PersonService {
    private final PersonRepository repository;//

    public PersonService(){
        this.repository = new FilePersonRepository();
    }

    public PersonService(PersonRepository repository){
        this.repository = repository;
    }

    public void distributeStudents() {
        Person first = new Person();
        Person second = new Person();
        Person third = new Person();

        repository.save(first);
        repository.save(second);
        repository.save(third);
    }

    public List<Person> findVeterans(){
        List<Person> all = repository.findAll();
        return all.stream().filter(person ->
                (Year.now().getValue() - person.getYearOfBirth()) > 39).
                collect(Collectors.toList());
    }



}
