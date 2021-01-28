package com.company.repository.player;

import com.company.domain.PlayerDecorator.DefinedPerson;
import com.company.repository.DataBaseSample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLPersonRepository implements PersonRepository {
    private final DataBaseSample dataBase;


    public SQLPersonRepository() throws SQLException {
        dataBase = new DataBaseSample();
        String tableNameQuery = "persons";
        dataBase.dropTable(tableNameQuery);
        String createTableQuery = "create table persons (id serial primary key,name varchar(30), yearOfBirth  int)";
        dataBase.createDB(tableNameQuery, createTableQuery);
    }

    @Override
    public void save(DefinedPerson person) throws Exception {
        Connection connection = dataBase.getConnection();
        String sql = "insert into persons (id,name,yearOfBirth) values (?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, (int) person.getID());
        statement.setString(2, person.getName());
        statement.setInt(3, person.getYearOfBirth());
        statement.execute();
        statement.close();
        connection.close();
    }

    @Override
    public void remove(DefinedPerson person) throws Exception {
        Connection connection = dataBase.getConnection();
        String sql = "delete from persons where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, (int) person.getID());
        System.out.println(statement.executeUpdate());
        statement.close();
        connection.close();
    }

    @Override
    public DefinedPerson findById(long personId) throws SQLException {
        Connection connection = dataBase.getConnection();
        String sql = "select * from persons where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        statement.setInt(1, (int) personId);
        ResultSet resultSet = statement.executeQuery();
        resultSet.first();
        long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        int yearOfBirth = resultSet.getInt("yearOfBirth");
        DefinedPerson person = new DefinedPerson(name, yearOfBirth, id);
        resultSet.close();
        statement.close();
        connection.close();
        return person;
    }

    @Override
    public List<DefinedPerson> findAll() throws SQLException {
        List<DefinedPerson> persons = new ArrayList<>();
        Connection connection = dataBase.getConnection();
        String sql = "select * from persons ";
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
        connection.close();
        return persons;
    }
}
