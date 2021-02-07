package com.company.repository.hibernate;

import com.company.domain.playerDecorator.DefinedPerson;
import org.junit.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class HbPersonRepositoryIntegrationTest {
    private static HbPersonRepository personRepository;
    private DefinedPerson person;
    private DefinedPerson person1;

    @BeforeClass
    public static void setUp() {
        personRepository = new HbPersonRepository();
    }

    @Before
    public void before() {
        person = new DefinedPerson();
        person1 = new DefinedPerson();
        person1.setName("roman");
        person1.setYearOfBirth(1996);
        person.setName("abc");
        person.setYearOfBirth(1990);
        personRepository.save(person);
        personRepository.save(person1);
    }

    @Test
    public void save() {
        DefinedPerson person2 = new DefinedPerson();
        person2.setName("volodya");
        person2.setYearOfBirth(2000);
        personRepository.save(person2);

        DefinedPerson fromDB = personRepository.findById(3);
        assertEquals(person2, fromDB);
    }

    @Test
    public void remove() {
        DefinedPerson personToDelete = personRepository.findById(2);

        personRepository.remove(personToDelete);
        List<DefinedPerson> all = personRepository.findAll();

        assertFalse(all.contains(personToDelete));
    }

    @Test
    public void findById() {
        DefinedPerson actual = personRepository.findById(2);

//        System.out.println(actual);
//        System.out.println("LIST" + personRepository.findAll());

        assertEquals(person, actual);
    }

    @Test
    public void findAll() {
        List<DefinedPerson> expected = Arrays.asList(person, person1);
        List<DefinedPerson> all = personRepository.findAll();

        assertEquals(expected, all);
    }

    @After
    public void after() {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();
        Query delete_from_definedPerson = entityManager.createQuery("delete from DefinedPerson");
        delete_from_definedPerson.executeUpdate();
        entityManager.getTransaction().commit();
    }

    @AfterClass
    public static void shutdown() {
        EntityManagerProvider.shutdown();
    }

}