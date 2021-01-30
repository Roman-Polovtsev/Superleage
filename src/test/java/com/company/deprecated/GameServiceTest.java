package com.company.deprecated;

import com.company.domain.GameDecorator.Game;
import com.company.domain.GameDecorator.PlannedGame;
import com.company.domain.Team;
import com.company.repository.Games.GamesRepository;
import com.company.services.GameService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

public class GameServiceTest {
    GamesRepository repository;
    GameService service;

    @Before
    public void beforeTests() {
        repository = Mockito.mock(GamesRepository.class);
        service = new GameService(repository);
    }


    @Test
    public void createGame() {
        Team team1 = new Team();
        Team team2 = new Team("guest");

        service.createGame(team1, team2);

        Mockito.verify(repository, Mockito.times(1)).save(Matchers.anyObject());
    }

}