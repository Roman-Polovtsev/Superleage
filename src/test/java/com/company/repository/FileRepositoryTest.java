package com.company.repository;

import com.company.domain.Team;
import com.company.util.FileHandlerSaveException;
import com.company.util.FileReadException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class FileRepositoryTest {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    FileHandler<Team> fileHandler;
    Path filepath;
    Path repoFilePath;
    FileRepository<Team> repository;
    Team team;
    Team team1;
    List<Team> teamList;


    @Before
    public void before() {

        filepath = Mockito.mock(Path.class);
        fileHandler = Mockito.mock(FileHandler.class);
        repository = new FileRepository(logger, repoFilePath, filepath, fileHandler);
        team = new Team(112);
        team1 = new Team(321);
        teamList = new ArrayList<>();
        teamList.addAll(Arrays.asList(team, team1));
    }

    @Test
    public void save() throws Repository.FileRepositoryException, FileReadException, FileHandlerSaveException {
        Team teamNew = new Team(228);
        Mockito.when(fileHandler.deserializedFile()).thenReturn(teamList);

        repository.save(teamNew);
        List<Team> all = repository.getAll();

        Mockito.verify(fileHandler, Mockito.times(1)).save(Mockito.any());
        assertTrue(all.contains(teamNew));
        assertEquals(3,all.size());
    }

    @Test
    public void remove() {
    }

    @Test
    public void findById() {
    }

    @Test
    public void getAll() throws FileReadException, Repository.FileRepositoryException {
        Mockito.when(fileHandler.deserializedFile()).thenReturn(teamList);
        List<Team> all = repository.getAll();


        assertFalse(all.isEmpty());
        assertEquals(2, all.size());
        assertTrue(all.contains(team));
        assertTrue(all.contains(team1));
    }
}