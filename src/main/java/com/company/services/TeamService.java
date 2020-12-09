package com.company.services;

import com.company.domain.Player;
import com.company.domain.Team;
import com.company.repository.team.FileTeamRepository;
import com.company.repository.team.TeamRepository;

import java.util.List;
import java.util.Set;

public class TeamService {
    TeamRepository teamRepository = new FileTeamRepository();

    public void addTeam (Team team){
        teamRepository.save(team);
    }

    public Team findHighest (){
        List<Team> all = teamRepository.getAll();
        float max = 0;
        Team highestTeam = teamRepository.findById(0);
        for (Team team: all
             ) {
           if(team.getAverageHeight()> max) {
               max = team.getAverageHeight();
               highestTeam = team;
           }
        }
        return highestTeam;
    }
}
