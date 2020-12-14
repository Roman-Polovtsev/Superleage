package com.company.services;

import com.company.domain.Player;
import com.company.domain.Team;
import com.company.repository.player.FilePlayerRepository;
import com.company.repository.player.PlayerRepository;
import com.company.repository.team.FileTeamRepository;
import com.company.repository.team.TeamRepository;

import java.util.List;
import java.util.function.Consumer;

public class TeamService {
    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;

    public TeamService() {
        this(new FileTeamRepository(), new FilePlayerRepository());
    }

    public TeamService(TeamRepository teamRepository, PlayerRepository playerRepository) {
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
    }

    public TeamRepository getTeamRepository() {
        return teamRepository;
    }

    public void addTeam(Team team) {
        teamRepository.save(team);
    }

    public Team findHighest() {
        float max = 0;
        List<Team> all = teamRepository.getAll();
        Team highestTeam = teamRepository.getAll().get(0);
        for (Team team : all) {
            if (team.getAverageHeight() > max) {
                max = team.getAverageHeight();
                highestTeam = team;
            }
        }
        //todo: stream API
        return highestTeam;
    }

    private void someMethod(Team team) {

    }

    public PlayerRepository getPlayerRepository() {
        return playerRepository;
    }

    public void addPlayer(Team team, Player player) {

        Team byId = teamRepository.findById(team.hashCode());
        byId.addPlayer(player);
        playerRepository.remove(player);
        teamRepository.save(byId);
    }
}
