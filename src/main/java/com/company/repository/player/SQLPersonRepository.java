package com.company.repository.player;

import com.company.domain.PlayerDecorator.AbstractPerson;
import com.company.domain.PlayerDecorator.DefinedPerson;
import com.company.domain.PlayerDecorator.Player;
import com.company.repository.DataBaseSample;
import com.company.util.FileReadException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class SQLPersonRepository implements PersonRepository {
    private final DataBaseSample dataBase;


    public SQLPersonRepository() throws SQLException {
        dataBase = new DataBaseSample();
        dropTable();
        createTable();
    }

    public void createTable() throws SQLException {
        Connection connection = dataBase.getConnection();
        String sql = "create table persons (id serial primary key,name varchar(30), yearOfBirth  int)";
        dataBase.createDB(connection, sql);
        dataBase.closeConnection(connection);
    }

    public void dropTable() throws SQLException {
        Connection connection = dataBase.getConnection();
        dataBase.dropTable(connection, "persons");
        connection.close();
    }

    @Override
    public void save(AbstractPerson person) throws Exception {
        Connection connection = dataBase.getConnection();
        String sql = "insert into persons (id,name,yearOfBirth) values (?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, (int) DefinedPerson.idCounter-1);
        statement.setString(2, person.getName());
        statement.setInt(3, person.getYearOfBirth());
        statement.execute();
        statement.close();
        connection.close();
    }

    @Override
    public void remove(Player player) throws Exception {

    }

    @Override
    public Player findById(long personId) throws FileReadException {
        return null;
    }

    @Override
    public List<Player> findAll() throws FileReadException {
        return null;
    }
}
