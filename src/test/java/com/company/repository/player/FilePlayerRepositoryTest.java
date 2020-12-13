package com.company.repository.player;

import com.company.domain.Person;
import com.company.domain.Player;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FilePlayerRepositoryTest {
    PlayerRepository repository = new FilePlayerRepository();

    @Test
    public void save() {
        Player player =  new Player();
        repository.save(player);
        Player player1 = new Player();
        repository.save(player1);
        Player player2 = new Player("vbcvb");
        repository.save(player2);
    }

    @Test
    public void findAll() {
        repository.findAll();
    }


    @Test
    public void remove() {
        Player player2 = new Player("Petya");
        repository.save(player2);
        repository.remove(player2);
        repository.findAll();
    }

    @Test
    public void findById() {
        Player player = new Player("vbcvb");
        Player byId = repository.findById(player.hashCode());
        assertEquals(player,byId);
    }

}