package com.company.deprecated;

import com.company.domain.Deprecated.Player;
import com.company.domain.Team;
import com.company.repository.player.PlayerRepository;
import com.company.repository.team.TeamRepository;
import com.company.services.TeamService;
import com.company.util.FileReadException;
import org.junit.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

//todo add this to common service
public class TeamServiceTest {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    TeamService service = new TeamService();

    @Test
    public void addTeamTest() throws Exception {

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
    public void findHighestTest() throws Exception {
        service.addTeam(new Team());
        assertEquals(new Team(), new TeamService().findHighest());
    }

    @Test
    public void addPlayerTest() throws Exception {
        TeamRepository teams = Mockito.mock(TeamRepository.class);
        PlayerRepository players = Mockito.mock(PlayerRepository.class);
        TeamService service = new TeamService(teams,players);
        Team team = new Team("z");
      //  logger.info("{}", team.getMembers());
        service.addTeam(team);
        //  logger.info("{}",team);
        Player player = new Player("zazaza");
     //   logger.info("{}", player);
       // service.getPlayerRepository().save(player);
       // service.getPlayerRepository().findById(player.hashCode());
     //   service.addPlayer(team, player);
       // logger.debug("Checking team list after adding new player: {}", service.getTeamRepository().getAll());
        assertTrue(team.getMembers().contains(player));
    }

    @Test
    public void findSmallest() throws FileReadException, TeamRepository.FileRepositoryException {
        TeamRepository teamRepository = Mockito.mock(TeamRepository.class);
        PlayerRepository playerRepository = Mockito.mock(PlayerRepository.class);
        TeamService service = new TeamService(teamRepository, playerRepository);
        Team first = new Team();
        Team second = new Team("highest");
        Team third = new Team("abc");
//        first.addPlayer(new Player(172));
//        first.addPlayer(new Player(165));
//        second.addPlayer(new Player(183));
//        third.addPlayer(Arrays.asList(new Player(230),new Player(320), new Player(200)));
        when(teamRepository.getAll()).thenReturn(Arrays.asList(first, second, third));

        Team smallest = service.findSmallest();

        assertEquals(first, smallest);
    }

//    @Test
//    public void setCaptainTest(){
//        TeamRepository teamRepository = Mockito.mock(TeamRepository.class);
//        PlayerRepository playerRepository = Mockito.mock(PlayerRepository.class);
//        TeamService service = new TeamService(teamRepository,playerRepository);
//        Team team = new Team("abc");
//        Player player1 = new Player("afsa");
//        Player player2 = new Player();
//        Player player3 = new Player("123");
//        team.addPlayer(player1,player2,player3);
//        when(teamRepository.findById(team.getID())).thenReturn(team);
//        Captain captain =new Captain(player1, "123","321");
//
//        try{service.setCaptain(team);}
//        catch (IOException e){
//            logger.error("",e);
//        }
//        Team byId = teamRepository.findById(team.getID());
//        Captain expectedCaptain = byId.getCaptain();
//
//
//        assertEquals(captain,expectedCaptain);
//    }

    @Test
    public void test() throws TeamRepository.FileRepositoryException {
        TeamRepository teamRepository = Mockito.mock(TeamRepository.class);
        PlayerRepository playerRepository = Mockito.mock(PlayerRepository.class);
        TeamService service = new TeamService(teamRepository, playerRepository);
        Team first = new Team();
        Team second = new Team("highest");
        Team third = new Team("abc");
//        first.addPlayer(new Player(172));
//        first.addPlayer(new Player(250));
//        second.addPlayer(new Player(183));
//        third.addPlayer(Arrays.asList(new Player(130),new Player(120), new Player(100)));
        when(teamRepository.getAll()).thenReturn(Arrays.asList(first, second));

        Team highest = service.findHighest();

        assertEquals(first, highest);
    }
}


