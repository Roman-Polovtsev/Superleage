package com.company.services;

import com.company.domain.Address;
import com.company.domain.EnableGameTime;
import com.company.domain.Team;
import com.company.domain.gameDecorator.Game;
import com.company.domain.playerDecorator.Captain;
import com.company.domain.playerDecorator.DefinedPerson;
import com.company.domain.playerDecorator.Player;
import com.company.repository.DataBaseException;
import com.company.repository.Hall.GameTimeRepository;
import com.company.repository.Hall.SqlDaysRepository;
import com.company.repository.Hall.SqlGameTimeRepository;
import com.company.repository.Repository;
import com.company.repository.player.PersonRepository;
import com.company.repository.player.PlayerRepository;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

public class CommonService {
    public final PlayerRepository playerRepository;
    public final PersonRepository personRepository;
    public final IDService<DefinedPerson> personIDService;
    public final IDService<Player> playerIDService;

    public CommonService(PlayerRepository playerRepository, PersonRepository personRepository) {
        this.playerRepository = playerRepository;
        this.personRepository = personRepository;
        personIDService = new IDService<>();
        playerIDService = new IDService<>();
    }


    public CommonService(Repository<Game> gameRepository, Repository<Address> addressRepository) {
        this.playerRepository = null;
        this.personRepository = null;
        personIDService = new IDService<>();
        playerIDService = new IDService<>();
    }

    public void addNewTeam(String teamName, Player player, String number, String email) {
        Captain captain = new Captain(player, number, email, 1);
        Team team = new Team(null, null, teamName, captain);
    }

    public void addNewPlayer(String name, int yearOfBirth, int height, String position, String level) throws DataBaseException, Repository.FileRepositoryException {
        DefinedPerson person = new DefinedPerson(name, yearOfBirth, personIDService.newObjectID());
        Player player = new Player(person, height, position, level, playerIDService.newObjectID());
        personRepository.save(person);
        playerRepository.save(player);
    }

    public Player findPlayer(long id) throws Repository.FileRepositoryException, DataBaseException {
        return playerRepository.findById(id);
    }

    public List<Player> getAllPlayers() throws Repository.FileRepositoryException, DataBaseException {
        return playerRepository.findAll();
    }

    public void removePlayer(Player player) throws Repository.FileRepositoryException, DataBaseException {
        playerRepository.remove(player);
        personRepository.remove(new DefinedPerson(player.getName(), player.getYearOfBirth(), player.personID()));
    }


//    public void changeGameAddress(Game game, Address address) throws Exception {
//        Address addressRepositoryById = addressRepository.findById(address.getID());
//        System.out.println(addressRepositoryById);
//        Game byId = gameRepository.findById(game.getID());
//        PlannedGame updatedGame = new PlannedGame(byId,addressRepositoryById);
//        gameRepository.remove(byId);
//        gameRepository.save(updatedGame);
//    }
//
//    public List<AbstractPerson> findVeterans() throws Repository.FileRepositoryException, Repository.SQLRepositoryException {
//        Repository<AbstractPerson> repository = null;
//        List<AbstractPerson> all = repository.getAll();
//        return all.stream().filter(person ->
//                (Year.now().getValue() - person.getYearOfBirth()) > 39).
//                collect(Collectors.toList());
//    }

    public void addGameDays(LocalTime begin, LocalTime end, DayOfWeek day) throws DataBaseException {
        GameTimeRepository gameTimeRepository = new SqlGameTimeRepository();
        SqlDaysRepository daysRepository = SqlDaysRepository.getInstance();
        EnableGameTime gameTime = new EnableGameTime(1, begin, end, day);
        gameTimeRepository.save(gameTime);
        EnableGameTime byId = gameTimeRepository.getById(1);
        System.out.println(byId);
        System.out.println(byId.equals(gameTime));
    }


}
