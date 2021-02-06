package com.company.services;

import com.company.domain.Address;
import com.company.domain.gameDecorator.Game;
import com.company.domain.gameDecorator.PlannedGame;
import com.company.domain.Team;
import com.company.repository.DataBaseException;
import com.company.repository.FileRepository;
import com.company.repository.Repository;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.List;

@Ignore("for manual testing only")
public class CommonServiceTest {
    Repository<Address> addressRepository = new FileRepository<>("C:\\Users\\Роман\\IdeaProjects\\Superleague_new\\repository\\address.txt");
    Repository<Game> gameRepository = new FileRepository<>("C:\\Users\\Роман\\IdeaProjects\\Superleague_new\\repository\\games.txt");
    CommonService service = new CommonService(gameRepository, addressRepository);

    @Before
    public void before() throws Repository.FileRepositoryException, DataBaseException {
        gameRepository.createRepository();
        addressRepository.createRepository();
    }

    //TODO how make a throughout id assigning, when creating new objects
    @Test
    public void changeGameAddress() throws Exception {
        Address oldAddress = new Address(1, "old");
        Address newAddress = new Address(2, "new");
        Game game = new PlannedGame(new Team("home"), new Team("guest"), oldAddress, LocalDateTime.of(1998, 12, 13, 14, 0));
        addressRepository.save(oldAddress);
        addressRepository.save(newAddress);
        gameRepository.save(game);
        //  service.changeGameAddress(game, newAddress);

        List<Game> all = gameRepository.getAll();

        //   assertTrue(all.contains(game));
    }




    //todo refactor this with new classes
    @Test
    public void findVeterans() {
//        PersonRepository personRepository = Mockito.mock(PersonRepository.class);
//        PersonService service = new PersonService(personRepository);
//        Person person = new Person(1935);
//        Person person1 = new Person(2000);
//        Person person2 = new Person(1981);
//        Person person3 = new Person(1980);
//        when(personRepository.findAll()).thenReturn(Arrays.asList(person,person1,person2, person3));
//
//        List<Person> veterans = service.findVeterans();
//
//        assertFalse(veterans.isEmpty());
//        assertEquals(2, veterans.size());
    }
}