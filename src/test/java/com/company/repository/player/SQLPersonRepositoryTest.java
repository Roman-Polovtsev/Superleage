package com.company.repository.player;

import com.company.domain.playerDecorator.DefinedPerson;
import com.company.repository.DataBase;
import com.company.repository.DataBaseException;
import com.company.util.DBConnector;
import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.JUnit4;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.mockito.asm.tree.analysis.Value;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLPersonRepositoryTest {
    SQLPersonRepository repository;
    Statement statement;
    PreparedStatement preparedStatement;
    DBConnector connector;
    Connection connection;
    DataBase dataBase;
    DefinedPerson person;

    @Captor
    ArgumentCaptor<Integer> intCaptor = ArgumentCaptor.forClass(Integer.class);

    @Captor
    ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);


    @Before
    @Test
    public void before() throws DataBaseException {
        preparedStatement = Mockito.mock(PreparedStatement.class);
        statement = Mockito.mock(Statement.class);
        connector = Mockito.mock(DBConnector.class);
        connection = Mockito.mock(Connection.class);
        dataBase = Mockito.mock(DataBase.class);

        Mockito.doNothing().when(dataBase).dropTable(SQLPersonRepository.DEFAULT_TABLE_NAME);
        Mockito.doNothing().when(dataBase).createDB(SQLPersonRepository.DEFAULT_TABLE_NAME, SQLPersonRepository.DEFAULT_CREATE_QUERY);
        repository = new SQLPersonRepository(dataBase);

        Mockito.verify(dataBase, Mockito.times(1)).dropTable(SQLPersonRepository.DEFAULT_TABLE_NAME);
        Mockito.verify(dataBase, Mockito.times(1)).createDB(Matchers.anyString(), Matchers.anyString());
    }

    @Test
    public void save() throws DataBaseException, SQLException {
        person = new DefinedPerson();
        Mockito.when(dataBase.getConnection()).thenReturn(connection);
        Mockito.when(connection.prepareStatement(Matchers.anyString())).thenReturn(preparedStatement);
        Mockito.doNothing().when(preparedStatement).setInt(Matchers.anyInt(), intCaptor.capture());
        Mockito.doNothing().when(preparedStatement).setString(Matchers.anyInt(), stringArgumentCaptor.capture());
        Mockito.doNothing().when(connection).close();
        Mockito.when(preparedStatement.execute()).thenReturn(false);

        repository.save(person);


        Assert.assertEquals(person.getName(),stringArgumentCaptor.getValue());
        Mockito.verify(preparedStatement, Mockito.times(1)).setString(Matchers.anyInt(), Matchers.anyString());
        Mockito.verify(connection, Mockito.times(1)).close();
        Mockito.verify(connection, Mockito.times(1)).prepareStatement(Matchers.anyString());
        Mockito.verify(dataBase, Mockito.times(1)).getConnection();
        Mockito.verify(preparedStatement, Mockito.times(1)).execute();
        Mockito.verify(preparedStatement, Mockito.times(2)).setInt(Matchers.anyInt(), Matchers.anyInt());
    }

    @Test
    public void remove() {
    }

    @Test
    public void findById() {
    }

    @Test
    public void findAll() {
    }
}