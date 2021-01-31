package com.company.deprecated;

import com.company.domain.Team;
import com.company.repository.FileHandler;
import com.company.repository.team.FileTeamRepository;
import com.company.repository.team.TeamRepository;
import com.company.util.FileHandlerSaveException;
import com.company.util.FileReadException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class FileTeamRepositoryTest {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    FileHandler<Team> fileHandler;
    Path filepath;
    FileTeamRepository repository;
    Team team;
    Team team1;
    List<Team> teamList;


    @Before
    public void before() {

        filepath = Mockito.mock(Path.class);
        fileHandler = Mockito.mock(FileHandler.class);
        repository = new FileTeamRepository(logger, filepath, fileHandler);
        team = new Team("112");
        team1 = new Team("321");
        teamList = new ArrayList<>();
        teamList.addAll(Arrays.asList(team, team1));
    }

    @Test
    public void save() throws FileHandlerSaveException, FileReadException, TeamRepository.FileRepositoryException {
        Team team = new Team();
        Team team1 = new Team("123");
        repository.save(team);
        repository.save(team1);

        Mockito.when(fileHandler.deserializedFile()).thenReturn(teamList);

        Mockito.verify(fileHandler, Mockito.times(2)).save(Matchers.anyListOf(Team.class));
    }

    @Test
            (expected = TeamRepository.FileRepositoryException.class)
    public void saveEx() throws TeamRepository.FileRepositoryException, FileReadException {
        Team team = new Team();

        Mockito.when(fileHandler.deserializedFile()).thenThrow(new FileReadException("shit", new IOException()));
        repository.save(team);

    }

    @Test
    public void remove() throws TeamRepository.FileRepositoryException, FileReadException {
        Mockito.when(fileHandler.deserializedFile()).thenReturn(teamList);

        repository.remove(team1);
        List<Team> all = repository.getAll();

        assertEquals(1, all.size());
        assertTrue(all.contains(team));
        assertFalse(all.contains(team1));
    }

//    @Test
//    public void addSameObj() throws TeamRepository.FileRepositoryException {
//        Team team = new Team("112");
//        Team team1 = new Team("112");
//        repository.save(team);
//        repository.save(team1);
//
//        List<Team> all = repository.getAll();
//
//        assertEquals(team, team1);
//        assertFalse(all.isEmpty());
//        assertEquals(1, all.size());
//        assertTrue(all.contains(team));
//        assertTrue(all.contains(team1));
//    }

    @Test
    public void findById() throws TeamRepository.FileRepositoryException, FileReadException {

        Mockito.when(fileHandler.deserializedFile()).thenReturn(teamList);
        Team byId = repository.findById(team.getID());

        assertEquals(team, byId);
    }

    @Test
    public void getAll() throws FileReadException, TeamRepository.FileRepositoryException {

        Mockito.when(fileHandler.deserializedFile()).thenReturn(teamList);
        List<Team> all = repository.getAll();


        assertFalse(all.isEmpty());
        assertEquals(2, all.size());
        assertTrue(all.contains(team));
        assertTrue(all.contains(team1));
    }

    @After
    public void tearDown() {
        //repository.getAll().forEach(repository::remove);
    }


}