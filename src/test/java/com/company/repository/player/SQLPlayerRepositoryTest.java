package com.company.repository.player;

import com.company.domain.playerDecorator.DefinedPerson;
import com.company.domain.playerDecorator.Player;
import com.company.repository.DataBase;
import com.company.repository.DataBaseException;
import com.company.util.DBConnector;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static org.mockito.Mockito.when;

public class SQLPlayerRepositoryTest {
    SQLPlayerRepository repository;
    DataBase dataBase = Mockito.mock(DataBase.class);
    DBConnector connector = Mockito.mock(DBConnector.class);
    Player player = new Player(new DefinedPerson(), 190, "", "", 2);

    @Before
    public void before () throws DataBaseException {
        repository = new SQLPlayerRepository();
    }

    @Test
    public void save() throws DataBaseException {
        repository.save(player);
    }

    @Test
    public void remove() {
    }

    @Test
    public void findById() throws DataBaseException {
        //  Mockito.when(statement.executeQuery())
        repository.findById(player.getID());
    }

    public static void main(String[] args) throws DataBaseException {
        SQLPlayerRepository repository = new SQLPlayerRepository();
        SQLPersonRepository personRepository = new SQLPersonRepository();
        DefinedPerson person = new DefinedPerson("", 2, 20);
        personRepository.save(person);
        repository.save(new Player(person));

    }


    @Test
    public void findAll() throws SQLException {

    }
}