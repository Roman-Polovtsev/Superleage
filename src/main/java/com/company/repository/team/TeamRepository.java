package com.company.repository.team;

import com.company.domain.Team;

import java.util.List;


public interface TeamRepository {
    void save(Team team);

    void remove(Team team);

    Team findById ( long teamId );

    List<Team> getAll();

}