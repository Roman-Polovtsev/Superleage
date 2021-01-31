package com.company.repository.player;

import com.company.domain.PlayerDecorator.DefinedPerson;
import com.company.repository.DataBaseException;
import com.company.repository.DataBaseSample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLPersonRepository implements PersonRepository {
    private final DataBaseSample dataBase;


    public SQLPersonRepository() throws DataBaseException {
        dataBase = new DataBaseSample();
        String tableNameQuery = "persons";
        dataBase.dropTable(tableNameQuery);
        String createTableQuery = "create table persons (id serial primary key,name varchar(30), yearOfBirth  int)";
        dataBase.createDB(tableNameQuery, createTableQuery);
    }

    @Override
    public void save(DefinedPerson person) throws DataBaseException {
        Connection connection = dataBase.getConnection();
        String sql = "insert into persons (id,name,yearOfBirth) values (?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, (int) person.getID());
            statement.setString(2, person.getName());
            statement.setInt(3, person.getYearOfBirth());
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            throw new DataBaseException(String.format("Exception during saving person to DB: %s \nwith query %s", person, sql), e);
        }
        dataBase.closeConnection(connection);
    }

    @Override
    public void remove(DefinedPerson person) throws DataBaseException {
        Connection connection = dataBase.getConnection();
        String sql = "delete from persons where id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, (int) person.getID());
            System.out.println(statement.executeUpdate());
            statement.close();
        } catch (SQLException e) {
            throw new DataBaseException(String.format("Exception during deleting person to DB: %s \nwith query %s", person, sql), e);
        }
        dataBase.closeConnection(connection);
    }

    @Override
    public DefinedPerson findById(long personId) throws DataBaseException {
        Connection connection = dataBase.getConnection();
        DefinedPerson person = null;
        String sql = "select * from persons where id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            statement.setInt(1, (int) personId);
            ResultSet resultSet = statement.executeQuery();
            resultSet.first();
            long id = resultSet.getLong("id");
            String name = resultSet.getString("name");
            int yearOfBirth = resultSet.getInt("yearOfBirth");
            person = new DefinedPerson(name, yearOfBirth, id);
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            throw new DataBaseException(String.format("Exception during searching person in DB: %s \nwith query %s", person, sql), e);
        }
        dataBase.closeConnection(connection);
        return person;
    }

    @Override
    public List<DefinedPerson> findAll() throws DataBaseException {
        List<DefinedPerson> persons = new ArrayList<>();
        Connection connection = dataBase.getConnection();
        String sql = "select * from persons ";
        try {
            PreparedStatement statement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = statement.executeQuery();
            resultSet.beforeFirst();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                int yearOfBirth = resultSet.getInt("yearOfBirth");
                DefinedPerson person = new DefinedPerson(name, yearOfBirth, id);
                persons.add(person);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            throw new DataBaseException(String.format("Exception during getting all persons from DB with query %s", sql), e);
        }
        dataBase.closeConnection(connection);
        return persons;
    }
}
