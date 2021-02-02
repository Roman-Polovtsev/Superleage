package com.company.services;

import com.company.domain.Address;
import com.company.domain.Team;
import com.company.domain.gameDecorator.Game;
import com.company.domain.playerDecorator.Captain;
import com.company.domain.playerDecorator.DefinedPerson;
import com.company.domain.playerDecorator.Player;
import com.company.repository.DataBaseException;
import com.company.repository.Repository;
import com.company.repository.player.PersonRepository;
import com.company.repository.player.PlayerRepository;
import com.company.repository.player.SQLPersonRepository;
import com.company.repository.player.SQLPlayerRepository;

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

    public static void main(String[] args) throws Exception {
        SQLPersonRepository personRepository = new SQLPersonRepository();
        SQLPlayerRepository playerRepository = new SQLPlayerRepository();
        CommonService service = new CommonService(playerRepository, personRepository);
        service.addNewPlayer("ivan", 1995, 190, "opposite", "kms");
        service.addNewPlayer("lera", 1997, 160, "доигровщик", "");
        // System.out.println(service.findPlayer(1));
        //System.out.println(service.findPlayer(2));
        System.out.println(service.getAllPlayers());
        Player player = service.findPlayer(1);
        service.removePlayer(player);
        System.out.println(service.getAllPlayers());
        DefinedPerson person1 = new DefinedPerson("a", 1, 1);
        DefinedPerson person2 = new DefinedPerson("a", 1, 1);
        System.out.println(person1.equals(person2));
        System.out.println(service.personRepository.findAll());
    }
}
