package com.company.repository.hibernate;

import com.company.repository.player.PersonRepository;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.Assert.*;

public class HbPersonRepositoryTest {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("superleague");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    PersonRepository personRepository = new HbPersonRepository(entityManager);

    @Test
    public void save() {
    }

    @Test
    public void remove() {
    }

    @Test
    public void findById() {
    }

    @Test
    public void findAll() {
    }
}