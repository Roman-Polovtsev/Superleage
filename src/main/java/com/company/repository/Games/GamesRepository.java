package com.company.repository.Games;

import com.company.domain.Game;

import java.util.List;

public interface GamesRepository {

    void save(Game game);
    Game getById (long id);
    List<Game> getAll ();
    void delete (Game game);
}
