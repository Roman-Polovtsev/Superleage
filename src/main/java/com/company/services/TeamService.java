package com.company.services;

import com.company.domain.PlayerDecorator.Player;
import com.company.domain.Team;
import com.company.repository.player.FilePlayerRepository;
import com.company.repository.player.PlayerRepository;
import com.company.repository.team.FileTeamRepository;
import com.company.repository.team.TeamRepository;
import com.company.util.FileReadException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.List;
import java.util.Set;


public class TeamService {
    private final Logger logger;
    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;

    public TeamService() {
        this(new FileTeamRepository(), new FilePlayerRepository(), LoggerFactory.getLogger(TeamService.class));
    }

    public TeamService(TeamRepository teamRepository, PlayerRepository playerRepository) {
        this(teamRepository, playerRepository, LoggerFactory.getLogger(TeamService.class));
    }

    public TeamService(TeamRepository teamRepository, PlayerRepository playerRepository, Logger logger) {
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
        this.logger = logger;
    }

    public TeamRepository getTeamRepository() {
        return teamRepository;
    }

    public PlayerRepository getPlayerRepository() {
        return playerRepository;
    }

    public void addTeam(Team team) throws Exception {
        teamRepository.save(team);
    }

    public Set<Player> getMembers(Team team) throws TeamRepository.FileRepositoryException {
        Team team1 = teamRepository.findById(team.getID());
        return team1.getMembers();
    }


//    public void setCaptain(Team team) {
//        team = new Team(LoggerFactory.getLogger(Team.class), team.getName(), team.)
//    }

//    public void setCaptain (Team team) throws IOException {
//        Set<Player> members = getMembers(team);
//        Object[] players = members.toArray();
//        logger.info("Set of team members, choose the number of one you want to set as a team`s captain:\n{}",players);
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        int number = reader.read();
//        Player chosenAsCaptain = (Player) players[number];
//        logger.info("Type phone number of captain:\n");
//        String phoneNumber = reader.readLine();
//        logger.info("Type email of captain:\n");
//        String email = reader.readLine();
//        Captain captain = new Captain(chosenAsCaptain,phoneNumber,email);
//        Team team1 = teamRepository.findById(team.getID());
//        Team updatedTeam = new Team(team1.getHall(),team1.getName(),team1.getID(),captain);
//        teamRepository.save(updatedTeam);
//    }

    public String getCaptainContacts(Team team) throws TeamRepository.FileRepositoryException {
        Team team1 = teamRepository.findById(team.getID());
        return team1.getCaptain().getContacts();
    }


    public Team findSmallest() throws FileReadException, TeamRepository.FileRepositoryException {
        List<Team> all = teamRepository.getAll();
        return all.stream().min(Comparator.comparing(Team::getAverageHeight)).orElseThrow();
    }

    public Team findHighest() throws TeamRepository.FileRepositoryException {
        float max = 0;
        List<Team> all = teamRepository.getAll();
        return all.stream().
                max((team1, team2) -> (int) (team1.getAverageHeight() - team2.getAverageHeight())).orElseThrow();
    }


    public void addPlayer(Team team, Player player) throws Exception {
        Team byId = teamRepository.findById(team.hashCode());
        byId.addPlayer(player);
        playerRepository.remove(player);
        teamRepository.save(byId);
    }
}
