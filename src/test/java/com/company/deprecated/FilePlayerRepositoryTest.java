package com.company.deprecated;

import com.company.domain.PlayerDecorator.DefinedPerson;
import com.company.domain.PlayerDecorator.Player;
import com.company.repository.player.FilePlayerRepository;
import com.company.repository.player.PlayerRepository;
import org.junit.After;
import org.junit.Test;

public class FilePlayerRepositoryTest {
    PlayerRepository repository = new FilePlayerRepository("C:\\Users\\Роман\\IdeaProjects\\Superleage_new\\repositories");

    @Test
    public void findAll() throws Exception {
        Player first = new Player();
        Player second = new Player();
//        repository.save(first);
//        repository.save(second);
//
//        List<Player> actualPlayers = repository.findAll();

//        assertFalse(actualPlayers.isEmpty());
//        assertTrue(actualPlayers.contains(first));
//        assertTrue(actualPlayers.contains(second));
//        assertEquals(2, actualPlayers.size());
    }

    @Test
    public void save() throws Exception {
        Player player = new Player();

//        repository.save(player);
//
////        List<Player> all = repository.findAll();
//        assertEquals(1, all.size());
//        assertTrue(all.contains(player));
    }


    @Test
    public void remove() throws Exception {
        Player player = new Player(new DefinedPerson("Petya"));
//        repository.save(player);
//
//        repository.remove(player);
//
//        List<Player> all = repository.findAll();
//        assertFalse(all.contains(player));
//        assertEquals(0, all.size());
    }

    @Test
    public void findById() throws Exception {
        Player player = new Player(new DefinedPerson("vbcvb"));
//        repository.save(player);
//
//        Player byId = repository.findById(player.hashCode());

        // assertEquals(player, byId);
    }

    @After
    public void tearDown() throws Exception {
        //   for (Player player : repository.findAll()) repository.remove(player);


    }


}