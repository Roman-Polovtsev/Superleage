package com.company.repository;

import com.company.util.DBConnector;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseTest {
    Statement statement = Mockito.mock(Statement.class);
    DBConnector connector = Mockito.mock(DBConnector.class);
    Connection connection = Mockito.mock(Connection.class);
    DataBase dataBase;
    String tableName = "tableName";
    String createQuery = "createQuery";

    @Before
    public void before() {
        dataBase = new DataBase(connector);
    }

    @Test
    public void getConnection() throws DataBaseException {
        Mockito.when(connector.getConnection()).thenReturn(connection);

        dataBase.getConnection();

        Mockito.verify(connector, Mockito.times(1)).getConnection();
    }

    @Test
    public void createDB() throws DataBaseException, SQLException {
        Mockito.when(connector.getConnection()).thenReturn(connection);
        Mockito.when(connection.createStatement()).thenReturn(statement);
        Mockito.doNothing().when(statement).addBatch(Mockito.anyString());
        Mockito.doReturn(new int[]{}).when(statement).executeBatch();
        Mockito.doNothing().when(connection).commit();
        Mockito.doNothing().when(connection).close();


        dataBase.createDB(tableName, createQuery);

        Mockito.verify(connection, Mockito.times(1)).createStatement();
        Mockito.verify(statement, Mockito.times(2)).addBatch(Matchers.anyString());
        Mockito.verify(connection, Mockito.times(1)).close();
        Mockito.verify(connection, Mockito.times(1)).commit();
        Mockito.verify(statement, Mockito.times(1)).executeBatch();
    }

    @Test
    public void dropTable() throws DataBaseException, SQLException {
        Mockito.when(connector.getConnection()).thenReturn(connection);
        Mockito.when(connection.createStatement()).thenReturn(statement);
        Mockito.doNothing().when(connection).close();


        dataBase.dropTable(tableName);

        Mockito.verify(connection, Mockito.times(1)).createStatement();
        Mockito.verify(connection, Mockito.times(1)).close();
        Mockito.verify(statement, Mockito.times(1)).executeUpdate(Matchers.anyString());
    }
}