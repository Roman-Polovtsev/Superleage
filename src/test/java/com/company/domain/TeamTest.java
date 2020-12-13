package com.company.domain;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Year;

import static org.junit.Assert.*;

public class TeamTest {
    Logger logger = LoggerFactory.getLogger(TeamTest.class);
    Team team = new Team();
    Player player1 =  new Player("a",1995);

    @Test
    public void addPlayer() {
        System.out.println(Year.now().getValue());
        team.addPlayer(player1);
        System.out.println(team.getMembers());
        team.addPlayer(new Player("1",2000));
        System.out.println(team.getMembers());
        team.addPlayer(new Player("2", 2021));
        System.out.println(team.getMembers());
    }

    @Test
    public void testAddPlayer() {
    }

    @Test
    public void deletePlayer() {
        team.addPlayer(player1);
        Team team2 = team;
       // System.out.println(team2.getMembers());
        System.out.println(team.getMembers());
        logger.info("{}",team.getMembers());
        team2.deletePlayer(player1);
        logger.info("{}",team.getMembers());
        //team2.deletePlayer(player1);
      //  logger.info("{}",team.getMembers());

    }
}