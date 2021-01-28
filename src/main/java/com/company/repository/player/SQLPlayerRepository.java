package com.company.repository.player;

import com.company.domain.PlayerDecorator.AbstractPerson;
import com.company.domain.PlayerDecorator.DefinedPerson;
import com.company.domain.PlayerDecorator.Player;
import com.company.repository.DataBaseSample;
import com.company.util.FileReadException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLPlayerRepository implements PlayerRepository {
    private final DataBaseSample dataBase;
    private final String tableNameQuery = "players";
    private final String createTableQuery = "create table players (id serial primary key, height int,position varchar(20), level varchar(20), person_id int, " +
            "CONSTRAINT fk_person_id FOREIGN KEY (person_id) REFERENCES persons(id) on delete cascade)";

    public SQLPlayerRepository() throws SQLException {
        dataBase = new DataBaseSample();
        dataBase.dropTable(tableNameQuery);
        dataBase.createDB(tableNameQuery,createTableQuery);
    }


    @Override
    public void save(Player player) throws Exception {
        Connection connection = dataBase.getConnection();
        String sql = "insert into players (id, height, position, level, person_id) values (?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, (int) player.getID());
        statement.setInt(2, player.getHeight());
        statement.setString(3, player.getPosition());
        statement.setString(4, player.getLevel());
        statement.setInt(5, (int) player.personID());
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    @Override
    public void remove(Player player) throws Exception {
        Connection connection = dataBase.getConnection();
        String sql = "delete from players where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, (int) player.getID());
        System.out.println(statement.executeUpdate());
        statement.close();
        connection.close();
    }

    @Override
    public Player findById(long playerID) throws FileReadException, SQLException {
        Connection connection = dataBase.getConnection();
        String sql = "select * from players left join persons on players.person_id=persons.id where players.id = ?";
        PreparedStatement statement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        statement.setInt(1, (int) playerID);
        ResultSet resultSet = statement.executeQuery();
        resultSet.first();
        long id = resultSet.getLong("id");
        long person_id = resultSet.getLong("person_id");
        String name = resultSet.getString("name");
        int height = resultSet.getInt("height");
        int yearOfBirth = resultSet.getInt("yearOfBirth");
        String position = resultSet.getString("position");
        String level = resultSet.getString("level");
        AbstractPerson person = new DefinedPerson(name, yearOfBirth, person_id);
        Player player = new Player(person, height, position, level, id);
        resultSet.close();
        statement.close();
        connection.close();
        return player;
    }

    @Override
    public List<Player> findAll() throws FileReadException, SQLException {
        List<Player> players = new ArrayList<>();
        Connection connection = dataBase.getConnection();
        String sql = "select * from players left join persons on players.person_id=persons.id ";
        PreparedStatement statement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet resultSet = statement.executeQuery();
        resultSet.beforeFirst();
        while (resultSet.next()) {
            long id = resultSet.getLong("id");
            long person_id = resultSet.getLong("person_id");
            String name = resultSet.getString("name");
            int height = resultSet.getInt("height");
            int yearOfBirth = resultSet.getInt("yearOfBirth");
            String position = resultSet.getString("position");
            String level = resultSet.getString("level");
            AbstractPerson person = new DefinedPerson(name, yearOfBirth, person_id);
            Player player = new Player(person, height, position, level, id);
            players.add(player);
        }
        resultSet.close();
        statement.close();
        connection.close();
        return players;
    }
}
