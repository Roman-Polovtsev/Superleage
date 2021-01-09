package com.company.repository.team;

import com.company.domain.Team;
import com.company.repository.FileHandlerSaveException;
import org.junit.After;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

import static org.junit.Assert.*;

public class FileTeamRepositoryTest {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    FileTeamRepository repository = new FileTeamRepository();

    @Test
    public void save() throws FileHandlerSaveException {
        Team team = new Team();
        Team team1 = new Team(123);
        repository.save(team);
        repository.save(team1);

        List<Team> all = repository.getAll();

        assertEquals(2, all.size());
        assertTrue(all.contains(team));
        assertTrue(all.contains(team1));
    }

    @Test
    public void remove() throws FileHandlerSaveException {
        Team team = new Team(123);
        Team team1 = new Team(12);
        repository.save(team);
        repository.save(team1);

        repository.remove(team1);
        List<Team> all = repository.getAll();

        assertEquals(1, all.size());
        assertTrue(all.contains(team));
        assertFalse(all.contains(team1));
    }

    @Test
    public void addSameObj() throws FileHandlerSaveException {
        Team team = new Team(112);
        Team team1 = new Team(112);
        repository.save(team);
        repository.save(team1);

        List<Team> all = repository.getAll();

        assertEquals(team, team1);
        assertFalse(all.isEmpty());
        assertEquals(1, all.size());
        assertTrue(all.contains(team));
        assertTrue(all.contains(team1));
    }

    @Test
    public void findById() throws FileHandlerSaveException {
        Team team = new Team();
        repository.save(team);

        Team byId = repository.findById(team.getID());

        assertEquals(team, byId);
    }

    @Test
    public void getAll() throws FileHandlerSaveException {
        Team team = new Team(112);
        Team team1 = new Team(321);
        repository.save(team);
        repository.save(team1);

        List<Team> all = repository.getAll();

        assertFalse(all.isEmpty());
        assertEquals(2, all.size());
        assertTrue(all.contains(team));
        assertTrue(all.contains(team1));
    }

    @After
    public void tearDown()  {
        //repository.getAll().forEach(repository::remove);
    }


}