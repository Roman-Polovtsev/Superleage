package com.company.repository.team;

import com.company.domain.Team;

import java.util.List;

public class FakeTeamRepository implements TeamRepository{
    List<Team> teams;

    @Override
    public void createRepository() {
    }

    @Override
    public void save(Team team) {
    }

    @Override
    public void remove(Team team) {
    }

    @Override
    public Team findById(long teamId) {
        return null;
    }

    @Override
    public List<Team> getAll() {
        return null;
    }
}
