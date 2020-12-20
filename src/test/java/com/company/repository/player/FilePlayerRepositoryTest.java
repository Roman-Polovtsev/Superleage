package com.company.repository.player;

import com.company.domain.Player;
import org.junit.After;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FilePlayerRepositoryTest {
    PlayerRepository repository = new FilePlayerRepository("C:\\Users\\Роман\\IdeaProjects\\Superleage_new\\repositories");

    @Test
    public void findAll() {
        Player first = new Player();
        Player second = new Player();
        repository.save(first);
        repository.save(second);

        List<Player> actualPlayers = repository.findAll();

        assertFalse(actualPlayers.isEmpty());
        assertTrue(actualPlayers.contains(first));
        assertTrue(actualPlayers.contains(second));
        assertEquals(2, actualPlayers.size());
    }

    @Test
    public void save() {
        Player player = new Player();

        repository.save(player);

        List<Player> all = repository.findAll();
        assertEquals(1, all.size());
        assertTrue(all.contains(player));
    }


    @Test
    public void remove() {
        Player player = new Player("Petya");
        repository.save(player);

        repository.remove(player);

        List<Player> all = repository.findAll();
        assertFalse(all.contains(player));
        assertEquals(0, all.size());
    }

    @Test
    public void findById() {
        Player player = new Player("vbcvb");
        repository.save(player);

        Player byId = repository.findById(player.hashCode());

        assertEquals(player, byId);
    }

    @After
    public void tearDown() {
        for (Player player : repository.findAll()) repository.remove(player);
    }


}