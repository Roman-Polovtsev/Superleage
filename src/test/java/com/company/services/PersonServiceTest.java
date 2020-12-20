package com.company.services;

import com.company.domain.Person;
import com.company.repository.person.PersonRepository;
import org.junit.Test;
import org.mockito.Mockito;;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.Assert.*;
public class PersonServiceTest {

    @Test
    public void findVeterans() {
        PersonRepository personRepository = Mockito.mock(PersonRepository.class);
        PersonService service = new PersonService(personRepository);
        Person person = new Person(1935);
        Person person1 = new Person(2000);
        Person person2 = new Person(1981);
        Person person3 = new Person(1980);
        when(personRepository.findAll()).thenReturn(Arrays.asList(person,person1,person2, person3));

        List<Person> veterans = service.findVeterans();

        assertFalse(veterans.isEmpty());
        assertEquals(2, veterans.size());
    }
}