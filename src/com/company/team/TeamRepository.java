package com.company.team;

import com.company.domain.Team;

import java.util.List;


public interface TeamRepository {
    void save(Team team);

    void remove(Team team);

    Team findByName( String name);

    Team findById ( long id );

    List<Team> getAll();

}