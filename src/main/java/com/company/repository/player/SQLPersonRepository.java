package com.company.repository.player;

import com.company.domain.playerDecorator.DefinedPerson;
import com.company.repository.DataBase;
import com.company.repository.DataBaseException;
import com.company.util.PoolConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLPersonRepository implements PersonRepository {
    private final DataBase dataBase;
    private final String tableName;
    private final String createTableQuery;
    public static final String DEFAULT_TABLE_NAME = "persons";
    public static final String DEFAULT_CREATE_QUERY = "create table persons (id serial primary key,name varchar(30), yearOfBirth  int)";

    public SQLPersonRepository() throws DataBaseException {
        this(new DataBase(new PoolConnector()));
    }

    public SQLPersonRepository(DataBase dataBase) throws DataBaseException {
        this(dataBase,DEFAULT_TABLE_NAME,DEFAULT_CREATE_QUERY);
    }

    public SQLPersonRepository(DataBase dataBase, String tableName, String createTableQuery) throws DataBaseException {
        this.dataBase = dataBase;
        this.tableName = tableName;
        this.createTableQuery = createTableQuery;
        init();
    }

    private void init() throws DataBaseException {
        dataBase.dropTable(tableName);
        dataBase.createDB(tableName, createTableQuery);
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
            connection.close();
        } catch (SQLException e) {
            throw new DataBaseException(String.format("Exception during saving person to DB: %s \nwith query %s", person, sql), e);
        }
    }

    @Override
    public void remove(DefinedPerson person) throws DataBaseException {
        Connection connection = dataBase.getConnection();
        String sql = "delete from persons where id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, (int) person.getID());
            statement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new DataBaseException(String.format("Exception during deleting person to DB: %s \nwith query %s", person, sql), e);
        }

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
            resultSet.next();
            person = getPerson(resultSet);
            connection.close();
        } catch (SQLException e) {
            throw new DataBaseException(String.format("Exception during searching person in DB: %s \nwith query %s", person, sql), e);
        }

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
                DefinedPerson person = getPerson(resultSet);
                persons.add(person);
            }
            connection.close();
        } catch (SQLException e) {
            throw new DataBaseException(String.format("Exception during getting all persons from DB with query %s", sql), e);
        }
        return persons;
    }

    private DefinedPerson getPerson(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        int yearOfBirth = resultSet.getInt("yearOfBirth");
        return new DefinedPerson(name, yearOfBirth, id);
    }
}
