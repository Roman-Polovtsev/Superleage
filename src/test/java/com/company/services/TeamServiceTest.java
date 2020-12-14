package com.company.services;

import com.company.domain.Player;
import com.company.domain.Team;
import com.company.repository.player.FilePlayerRepository;
import com.company.repository.player.PlayerRepository;
import com.company.repository.team.FakeTeamRepository;
import com.company.repository.team.FileTeamRepository;
import com.company.repository.team.TeamRepository;
import junit.framework.TestCase;
import org.junit.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.Transient;
import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class TeamServiceTest {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    TeamService service = new TeamService();

    @Test
    public void addTeamTest() {
        service.getTeamRepository().createRepository();
        service.getTeamRepository().save(new Team("first team"));
        logger.debug("Team repository before adding Team: {}", service.getTeamRepository().getAll());
        Team team = new Team("alfa");
        service.addTeam(team);
        //   logger.debug("here after adding team {}", team.getName());
        logger.debug("Team repository after adding Team: {}", service.getTeamRepository().getAll());
        service.getTeamRepository().remove(team);
    }

    @Test
    public void findHighestTest() {
        service.addTeam(new Team());
        assertEquals(new Team(), new TeamService().findHighest());
    }

    @Test
    public void addPlayerTest() {
        Team team = new Team("z");
        logger.info("{}", team.getMembers());
        service.addTeam(team);
        //  logger.info("{}",team);
        Player player = new Player("zazaza");
        logger.info("{}", player);
        service.getPlayerRepository().save(player);
        service.getPlayerRepository().findById(player.hashCode());
        service.addPlayer(team, player);
        //logger.info("{}",team.getMembers());
        logger.debug("Checking team list after adding new player: {}", service.getTeamRepository().getAll());
    }

    @Test
    public void test() {
        TeamRepository teamRepository = Mockito.mock(TeamRepository.class);
        PlayerRepository playerRepository = Mockito.mock(PlayerRepository.class);
        TeamService service = new TeamService(teamRepository, playerRepository);
        Team first = new Team();
        Team second = new Team("highest");
        first.addPlayer(new Player(172));
        second.addPlayer(new Player(183));
        when(teamRepository.getAll()).thenReturn(Arrays.asList(first, second));

        Team highest = service.findHighest();

        assertEquals(second, highest);
    }
}


