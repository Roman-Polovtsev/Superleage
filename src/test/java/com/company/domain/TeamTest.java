package com.company.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Year;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class TeamTest {
    private static Team fullTeam;
    private static final Logger logger = LoggerFactory.getLogger(TeamTest.class);
    private static final String name = "full complect team";
    private static Hall hall;
    private static long ID;
    private static Captain captain;
    private final Player player1 = new Player(190, 1994);
    private final Player player2 = new Player(195, 1996);
    private final List<Player> newPlayers = Arrays.asList(player1, player2);
    private final List<Player> allPlayers = Arrays.asList(player1, player2, captain);

    // TODO: 16.01.2021 create captain as a decorator of player
    @BeforeClass
    public static void beforeSetup() {
        hall = new Hall(new Address("spb", "nevsky", "23"));
        captain = new Captain(new Player("Ivan", 1995, 1, "god", "opposite", 200));
        ID = 256;
        fullTeam = new Team(logger, hall, name, ID, captain);
    }


    @Test
    public void getName() {
        Team team = new Team("new team");
        String expected = "new team";

        String actual = team.getName();

        assertEquals(expected, actual);
    }

    @Test
    public void getHall() {
        Hall actual = fullTeam.getHall();

        assertEquals(hall, actual);
    }

    @Test
    public void getID() {
        long actual = fullTeam.getID();

        assertEquals(ID, actual);
    }

    @Test
    public void addPlayer() {
        Player player = new Player("michael scott");

        fullTeam.addPlayer(player);
        Set<Player> members = fullTeam.getMembers();

        assertTrue(members.contains(player));
        assertEquals(members.size(), 2);
    }

    @Test
    public void testAddPlayer() {
        fullTeam.addPlayer(newPlayers);
        Set<Player> members = fullTeam.getMembers();

        assertTrue(members.containsAll(newPlayers));
        assertEquals(members.size(),3);
        fullTeam.deletePlayer(newPlayers);
    }

    @Test
    public void deletePlayer() {
    }

    @Test
    public void getAverageHeight() {
        float expected = 195;

        fullTeam.addPlayer(newPlayers);
        float actual = fullTeam.getAverageHeight();

        assertEquals(expected,actual,1);
        assertEquals(fullTeam.getMembers().size(),3);
        fullTeam.deletePlayer(newPlayers);
        assertEquals(fullTeam.getMembers().size(),1);
    }

    @Test
    public void getAverageAge() {
        float expected = 26;

        fullTeam.addPlayer(newPlayers);
        float actual = fullTeam.getAverageAge();

        assertEquals(expected,actual,1);
        assertEquals(fullTeam.getMembers().size(),3);
        fullTeam.deletePlayer(newPlayers);
        assertEquals(fullTeam.getMembers().size(),1);
    }

    @Before
    @Test
    public void getMembersTest() {
        Set<Player> members = fullTeam.getMembers();

        assertNotNull(members);
        assertTrue(members.contains(captain));
    }

    @Test
    public void getCaptain() {
        Captain actual = fullTeam.getCaptain();

        assertEquals(captain, actual);
    }

    @After
    public void clear() {
        fullTeam.deletePlayer(newPlayers);
    }
}