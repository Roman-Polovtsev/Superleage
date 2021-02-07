package com.company.repository.hibernate;

import com.company.domain.playerDecorator.DefinedPerson;
import com.company.repository.player.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import java.util.List;

public class HbPersonRepository implements PersonRepository {
    private static final Logger logger = LoggerFactory.getLogger(HbPersonRepository.class);

    public HbPersonRepository() {
    }

    @Override
    public void save(DefinedPerson person) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.persist(person);
        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void remove(DefinedPerson person) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.contains(person) ? person : entityManager.merge(person));
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public DefinedPerson findById(long personId) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();
        DefinedPerson person = entityManager.find(DefinedPerson.class, personId);
        entityManager.getTransaction().commit();
        entityManager.close();
        return person;
    }

    @Override
    @SuppressWarnings("unchecked assignment")
    public List<DefinedPerson> findAll() {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        List<DefinedPerson> persons = entityManager.createQuery("from DefinedPerson").getResultList();
        logger.debug(persons.stream().toString());
        return persons;
    }
}
