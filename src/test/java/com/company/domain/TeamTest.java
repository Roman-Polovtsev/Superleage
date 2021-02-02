package com.company.domain;

import com.company.domain.playerDecorator.Captain;
import com.company.domain.playerDecorator.DefinedPerson;
import com.company.domain.playerDecorator.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class TeamTest {
    private Team fullTeam;
    private final Logger logger = LoggerFactory.getLogger(TeamTest.class);
    private final String name = "full complected team";
    private Hall hall;
    private Captain captain;
    private final Player player1 = new Player(new DefinedPerson("", 1994, 1), 190, "", "", 1);
    private final Player player2 = new Player(new DefinedPerson("", 1996, 2), 195, "", "", 2);
    private final List<Player> newPlayers = Arrays.asList(player1, player2);
    private final Player player = new Player(new DefinedPerson("michael scott", 1990, 3));


    @Before
    @Test
    public void getMembersTest() {
        hall = new Hall(1, new Address(1, "spb", "nevsky", "23"));
        captain = new Captain(new Player(new DefinedPerson("Ivan", 1995, 4), 200, "god", "opposite", 4), "", "", 1);
        fullTeam = new Team(logger, hall, name, captain);
        Set<Player> members = fullTeam.getMembers();

        assertNotNull(members);
        assertTrue(members.contains(captain.getCaptainAsPlayer()));
    }

    @After
    public void clear() {
        fullTeam.deletePlayer(newPlayers);
        fullTeam.deletePlayer(player);
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
    public void addPlayer() {

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
        System.out.println(members);
        assertEquals(3, members.size());
    }

    @Test
    public void addCaptainAsPlayer() {
        System.out.println(fullTeam.getMembers());
        fullTeam.addPlayer(captain.getCaptainAsPlayer());
        System.out.println(fullTeam.getMembers());
    }

    @Test
    public void deletePlayer() {
        Set<Player> members = fullTeam.getMembers();
        fullTeam.deletePlayer(captain.getCaptainAsPlayer());

        assertFalse(members.contains(captain.getCaptainAsPlayer()));
        assertEquals(0, members.size());
    }

    @Test
    public void getAverageHeight() {
        float expected = 195;

        fullTeam.addPlayer(newPlayers);
        float actual = fullTeam.getAverageHeight();

        assertEquals(expected, actual, 1);
        assertEquals(fullTeam.getMembers().size(), 3);
        fullTeam.deletePlayer(newPlayers);
        assertEquals(fullTeam.getMembers().size(), 1);
    }

    @Test
    public void getAverageAge() {
        float expected = 26;

        fullTeam.addPlayer(newPlayers);
        float actual = fullTeam.getAverageAge();

        assertEquals(expected, actual, 1);
        assertEquals(fullTeam.getMembers().size(), 3);
        fullTeam.deletePlayer(newPlayers);
        assertEquals(fullTeam.getMembers().size(), 1);
    }


    @Test
    public void getCaptain() {
        Captain actual = fullTeam.getCaptain();

        assertEquals(captain, actual);
    }


}