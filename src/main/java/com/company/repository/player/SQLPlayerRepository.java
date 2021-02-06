package com.company.repository.player;

import com.company.domain.playerDecorator.Person;
import com.company.domain.playerDecorator.DefinedPerson;
import com.company.domain.playerDecorator.Player;
import com.company.repository.DataBaseException;
import com.company.repository.DataBase;
import com.company.util.PoolConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLPlayerRepository implements PlayerRepository {
    private final DataBase dataBase;
    private static final String tableNameQuery = "players";
    private static final String createTableQuery = "create table players (id serial primary key, height int,position varchar(20), level varchar(20), person_id int, " +
            "CONSTRAINT fk_person_id FOREIGN KEY (person_id) REFERENCES persons(id) on delete cascade)";

    public SQLPlayerRepository() throws DataBaseException {
       // dataBase = new DataBase();
        dataBase = new DataBase(new PoolConnector());
        dataBase.dropTable(tableNameQuery);
        dataBase.createDB(tableNameQuery, createTableQuery);
    }

    @Override
    public void save(Player player) throws DataBaseException {
        Connection connection = dataBase.getConnection();
        String sql = "insert into players (id, height, position, level, person_id) values (?,?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, (int) player.getID());
            statement.setInt(2, player.getHeight());
            statement.setString(3, player.getPosition());
            statement.setString(4, player.getLevel());
            statement.setInt(5, (int) player.personID());
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new DataBaseException(String.format("Exception during saving player to DB: %s \nwith query %s", player, sql), e);
        }
    }

    @Override
    public void remove(Player player) throws DataBaseException {
        Connection connection = dataBase.getConnection();
        String sql = "delete from players where id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, (int) player.getID());
            System.out.println(statement.executeUpdate());
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new DataBaseException(String.format("Exception during deleting player from DB: %s \nwith query %s", player, sql), e);
        }
    }

    @Override
    public Player findById(long playerID) throws DataBaseException {
        Connection connection = dataBase.getConnection();
        Player player;
        String sql = "select * from players left join persons on players.person_id=persons.id where players.id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            statement.setInt(1, (int) playerID);
            ResultSet resultSet = statement.executeQuery();
            resultSet.first();
            player = getPlayer(resultSet);
            connection.close();
        } catch (SQLException e) {
            throw new DataBaseException(String.format("Exception during searching player by iD:%s in DB \nwith query %s", playerID, sql), e);
        }
        return player;
    }

    @Override
    public List<Player> findAll() throws DataBaseException {
        List<Player> players = new ArrayList<>();
        Connection connection = dataBase.getConnection();
        String sql = "select * from players left join persons on players.person_id=persons.id ";
        try {
            PreparedStatement statement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = statement.executeQuery();
            resultSet.beforeFirst();
            while (resultSet.next()) {
                Player player = getPlayer(resultSet);
                players.add(player);
            }
            connection.close();
        } catch (SQLException e) {
            throw new DataBaseException(String.format("Exception during getting all players from DB with query %s", sql), e);
        }
        return players;
    }

    private Player getPlayer(final ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("id");
        long person_id = resultSet.getLong("person_id");
        String name = resultSet.getString("name");
        int height = resultSet.getInt("height");
        int yearOfBirth = resultSet.getInt("yearOfBirth");
        String anyPosition = resultSet.getString("position");
        String level = resultSet.getString("level");
        Person person = new DefinedPerson(name, yearOfBirth, person_id);
        return new Player(person, height, anyPosition, level, id);
    }
}
