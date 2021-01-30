package com.company.services;

import com.company.domain.GameDecorator.*;
import com.company.domain.PlayerDecorator.Referee;
import com.company.domain.Result;
import com.company.domain.Team;
import com.company.repository.Games.FileGameRepository;
import com.company.repository.Games.GamesRepository;

public class GameService {
    GamesRepository repository;
    public GameService(GamesRepository repository) {
        this.repository = repository;
    }


    public void createGame (Team team1, Team team2){
        Game game = new PlannedGame(team1,team2);
        repository.save(game);
    }

//    public Game addGameResult(Game startedGame, Result result, Referee referee){
//        Game byId = repository.getById(schedule.getID());
//        Game updatedGame = new FinishedGame(byId,result,referee);
//        repository.save(updatedGame);
//        return updatedGame;
//    }
}
