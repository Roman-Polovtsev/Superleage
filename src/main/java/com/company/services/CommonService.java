package com.company.services;

import com.company.domain.Address;
import com.company.domain.GameDecorator.Game;
import com.company.domain.GameDecorator.PlannedGame;
import com.company.domain.PlayerDecorator.Referee;
import com.company.domain.Team;
import com.company.repository.Repository;

public class CommonService {
    Repository<Team> teamRepository;
    Repository<Game> gameRepository;
    Repository<Referee> refereeRepository;
    Repository<Address> addressRepository;

    public CommonService(Repository<Team> teamRepository, Repository<Game> gameRepository, Repository<Referee> refereeRepository, Repository<Address> addressRepository) {
        this.teamRepository = teamRepository;
        this.gameRepository = gameRepository;
        this.refereeRepository = refereeRepository;
        this.addressRepository = addressRepository;
    }

    public CommonService(Repository<Team> teamRepository, Repository<Game> gameRepository, Repository<Referee> refereeRepository) {
        this.teamRepository = teamRepository;
        this.gameRepository = gameRepository;
        this.refereeRepository = refereeRepository;
    }

    public CommonService(Repository<Game> gameRepository, Repository<Address> addressRepository) {
        this.gameRepository = gameRepository;
        this.addressRepository = addressRepository;
    }

    public void changeGameAddress(Game game, Address address) throws Exception {
        Address addressRepositoryById = addressRepository.findById(address.getID());
        System.out.println(addressRepositoryById);
        Game byId = gameRepository.findById(game.getID());
        PlannedGame updatedGame = new PlannedGame(byId, addressRepositoryById);
        gameRepository.remove(byId);
        gameRepository.save(updatedGame);
    }
}
