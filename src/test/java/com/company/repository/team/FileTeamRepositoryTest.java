package com.company.repository.team;

import com.company.domain.Team;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FileTeamRepositoryTest {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    FileTeamRepository repository =new FileTeamRepository();

    @Test
    public void save() {
//        List<Team> teamList1 = null, teamList2 = null;
//        try{ teamList1 = (List<Team>)repository.deserialize(Files.readAllBytes(repository.getFileTeamsPath()));}
//        catch (IOException exception){
//            exception.printStackTrace();
//        }
//        catch (ClassNotFoundException c){
//            c.printStackTrace();
//        }
        if(!Files.exists(repository.getFileTeamsPath()))
            repository.getFileHandler().fileCreating(repository.getRepoFilePath(),repository.getFileTeamsPath());
            List<Team> testTeam = new ArrayList<>();
            //testTeam.addAll(0,repository.getTeamList());
           // testTeam.add(new Team());
            testTeam.add(new Team());
            Object[] objects = testTeam.toArray();
            repository.save(new Team());

            Object[] objects1 = repository.getTeamList().toArray();
            assertEquals(testTeam.size(),repository.getTeamList().size());
            logger.info("arrays sizes are equal");
            assertArrayEquals(objects, objects1);
        logger.info("arrays are equal");
            try{
            testTeam = (List<Team>) repository.getSerializer().deserialize(Files.readAllBytes(repository.getFileTeamsPath()));}
            catch (IOException e)
            {
                logger.error("{}",e);
            }
            catch (ClassNotFoundException c){
                logger.error("{}",c);
            }
            objects = testTeam.toArray();
        assertEquals(testTeam, repository.getTeamList());

    }

    @Test
    public void remove() {
        repository.save(new Team());
        List<Team> all = repository.getAll();
        repository.remove(new Team());
        List<Team> all1 = repository.getAll();
        assertSame(all,all1);
    }

    @Test
    public void compare(){

        List<Team> teamBefore = null;
        List<Team> teamAfter = null;
        repository.save(new Team());
        repository.save(new Team("b"));
        try{
            teamBefore = (List<Team>) repository.getSerializer().deserialize(Files.readAllBytes(repository.getFileTeamsPath()));}
        catch (IOException e)
        {
            logger.error("{}",e);
        }
        catch (ClassNotFoundException c){
            logger.error("{}",c);
        }
        repository.save(new Team("b"));
        try{
            teamAfter = (List<Team>) repository.getSerializer().deserialize(Files.readAllBytes(repository.getFileTeamsPath()));}
        catch (IOException e)
        {
            logger.error("{}",e);
        }
        catch (ClassNotFoundException c){
            logger.error("{}",c);
        }
        assertEquals(teamBefore,teamAfter);

    }

    @Test
    public void findById() {
    }

    @Test
    public void getAll() {
    }


    @Test
    public void deletingFile() {
        repository.getFileHandler().deletingFile(repository.getRepoFilePath(),repository.getFileTeamsPath());
        assertTrue(Files.exists(repository.getRepoFilePath()));
        assertFalse(Files.exists(repository.getFileTeamsPath()));
    }

    @Test
    public void testFileCreating() {
        repository.getFileHandler().fileCreating(repository.getRepoFilePath(),repository.getFileTeamsPath());
        assertTrue(Files.exists(repository.getRepoFilePath()));
        assertTrue(Files.exists(repository.getFileTeamsPath()));
    }
}