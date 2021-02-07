package com.company.repository.player;

import com.company.domain.playerDecorator.DefinedPerson;
import com.company.repository.DataBase;
import com.company.repository.DataBaseException;
import com.company.util.DBConnector;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Matchers;
import org.mockito.Mockito;

import java.sql.*;

public class SQLPersonRepositoryTest {
    SQLPersonRepository repository;
    Statement statement;
    PreparedStatement preparedStatement;
    DBConnector connector;
    Connection connection;
    DataBase dataBase;
    DefinedPerson person;
    ResultSet resultSet;

    @Captor
    ArgumentCaptor<Integer> intCaptor = ArgumentCaptor.forClass(Integer.class);

    @Captor
    ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);

    @Before
    @Test
    public void before() throws DataBaseException {
        resultSet = Mockito.mock(ResultSet.class);
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


        Assert.assertEquals(person.getName(), stringArgumentCaptor.getValue());
        Mockito.verify(preparedStatement, Mockito.times(1)).setString(Matchers.anyInt(), Matchers.anyString());
        Mockito.verify(connection, Mockito.times(1)).close();
        Mockito.verify(connection, Mockito.times(1)).prepareStatement(Matchers.anyString());
        Mockito.verify(dataBase, Mockito.times(1)).getConnection();
        Mockito.verify(preparedStatement, Mockito.times(1)).execute();
        Mockito.verify(preparedStatement, Mockito.times(2)).setInt(Matchers.anyInt(), Matchers.anyInt());
    }

    @Test
    public void remove() throws DataBaseException, SQLException {
        person = new DefinedPerson();
        Mockito.when(dataBase.getConnection()).thenReturn(connection);
        Mockito.when(connection.prepareStatement(Matchers.anyString())).thenReturn(preparedStatement);
        Mockito.doNothing().when(preparedStatement).setInt(Matchers.anyInt(), intCaptor.capture());
        Mockito.doNothing().when(connection).close();
        Mockito.when(preparedStatement.executeUpdate()).thenReturn(1);

        repository.remove(person);

        Assert.assertEquals(person.getID(), intCaptor.getValue().longValue());
        Mockito.verify(dataBase, Mockito.times(1)).getConnection();
        Mockito.verify(preparedStatement, Mockito.times(1)).executeUpdate();
        Mockito.verify(connection, Mockito.times(1)).close();
        Mockito.verify(preparedStatement, Mockito.times(1)).setInt(Matchers.anyInt(), Matchers.anyInt());
    }

    @Test
    public void findById() throws DataBaseException, SQLException {
        DefinedPerson person = new DefinedPerson("1", 1990, 1);
        Mockito.when(dataBase.getConnection()).thenReturn(connection);
        Mockito.when(connection.prepareStatement(Matchers.anyString(), Matchers.eq(ResultSet.TYPE_SCROLL_INSENSITIVE), Matchers.eq(ResultSet.CONCUR_UPDATABLE))).thenReturn(preparedStatement);
        Mockito.doNothing().when(preparedStatement).setInt(Matchers.anyInt(), intCaptor.capture());
        Mockito.doNothing().when(connection).close();
        Mockito.when(resultSet.next()).thenReturn(true);
        Mockito.when(preparedStatement.executeQuery()).thenReturn(resultSet);
        Mockito.when(resultSet.getLong("id")).thenReturn(person.getID());
        Mockito.when(resultSet.getString("name")).thenReturn(person.getName());
        Mockito.when(resultSet.getInt("yearOfBirth")).thenReturn(person.getYearOfBirth());

        repository.findById(person.getID());

        Assert.assertEquals(person.getID(), intCaptor.getValue().longValue());
        Mockito.verify(resultSet, Mockito.times(1)).getLong(Matchers.anyString());
        Mockito.verify(resultSet, Mockito.times(1)).getString(Matchers.anyString());
        Mockito.verify(resultSet, Mockito.times(1)).getInt(Matchers.anyString());
        Mockito.verify(resultSet, Mockito.times(1)).next();
        Mockito.verify(dataBase, Mockito.times(1)).getConnection();
        Mockito.verify(preparedStatement, Mockito.times(1)).executeQuery();
        Mockito.verify(connection, Mockito.times(1)).close();
        Mockito.verify(preparedStatement, Mockito.times(1)).setInt(Matchers.anyInt(), Matchers.anyInt());
    }

    @Test
    public void findAll() throws DataBaseException, SQLException {
        DefinedPerson person = new DefinedPerson();
        Mockito.when(dataBase.getConnection()).thenReturn(connection);
        Mockito.when(connection.prepareStatement(Matchers.anyString(), Matchers.eq(ResultSet.TYPE_SCROLL_INSENSITIVE), Matchers.eq(ResultSet.CONCUR_UPDATABLE))).thenReturn(preparedStatement);
        Mockito.doNothing().when(connection).close();
        Mockito.doNothing().when(resultSet).beforeFirst();
        Mockito.when(resultSet.next()).thenReturn(true, true, false);
        Mockito.when(preparedStatement.executeQuery()).thenReturn(resultSet);
        Mockito.when(resultSet.getLong("id")).thenReturn(person.getID());
        Mockito.when(resultSet.getString("name")).thenReturn(person.getName());
        Mockito.when(resultSet.getInt("yearOfBirth")).thenReturn(person.getYearOfBirth());

        repository.findAll();

        Mockito.verify(resultSet, Mockito.times(2)).getLong("id");
        Mockito.verify(resultSet, Mockito.times(2)).getString("name");
        Mockito.verify(resultSet, Mockito.times(2)).getInt("yearOfBirth");
        Mockito.verify(resultSet, Mockito.times(3)).next();
        Mockito.verify(dataBase, Mockito.times(1)).getConnection();
        Mockito.verify(preparedStatement, Mockito.times(1)).executeQuery();
        Mockito.verify(connection, Mockito.times(1)).close();
    }
}