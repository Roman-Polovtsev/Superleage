package com.company.services;

import com.company.domain.Player;
import com.company.domain.Team;
import com.company.repository.player.FilePlayerRepository;
import com.company.repository.player.PlayerRepository;
import com.company.repository.team.FileTeamRepository;
import com.company.repository.team.TeamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Set;

public class TeamService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private TeamRepository teamRepository = new FileTeamRepository();
    private PlayerRepository playerRepository = new FilePlayerRepository();

    public TeamRepository getTeamRepository() {
        return teamRepository;
    }

    public void addTeam (Team team){
        teamRepository.save(team);
    }

    public Team findHighest (){
        List<Team> all = teamRepository.getAll();
        float max = 0;
        Team highestTeam = teamRepository.getAll().get(0);
        for (Team team: all
             ) {
           if(team.getAverageHeight()> max) {
               max = team.getAverageHeight();
               highestTeam = team;
           }
        }
        return highestTeam;
    }

    public PlayerRepository getPlayerRepository() {
        return playerRepository;
    }

    public void addPlayer(Team team, Player player){

        Team byId = teamRepository.findById(team.hashCode());
        byId.addPlayer(player);
        playerRepository.remove(player);
        teamRepository.save(byId);
    }
}
