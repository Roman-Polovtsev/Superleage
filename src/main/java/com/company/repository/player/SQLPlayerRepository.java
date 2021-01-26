package com.company.repository.player;

import com.company.domain.PlayerDecorator.DefinedPerson;
import com.company.domain.PlayerDecorator.Player;
import com.company.repository.DataBaseSample;
import com.company.util.FileReadException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class SQLPlayerRepository implements PlayerRepository {
    private final DataBaseSample dataBase;


    public SQLPlayerRepository() throws SQLException {
        dataBase = new DataBaseSample();
        dropTable();
        createTable();
    }

    public void dropTable() throws SQLException {
        Connection connection = dataBase.getConnection();
        dataBase.dropTable(connection, "players");
        connection.close();
    }


    public void createTable() throws SQLException {
        Connection connection = dataBase.getConnection();
        String sql = "create table players (id serial primary key, height int,position varchar(20), level varchar(20), person_id int REFERENCES persons(id) on delete cascade)";
        dataBase.createDB(connection, sql);
        dataBase.closeConnection(connection);
    }

    @Override
    public void save(Player player) throws Exception {
        Connection connection = dataBase.getConnection();
        String sql = "insert into players (id, height, position, level, person_id) values (?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, (int) Player.idCounter-1);
        statement.setInt(2, player.getHeight());
        statement.setString(3, player.getPosition());
        statement.setString(4, player.getLevel());
        statement.setInt(5, (int) DefinedPerson.idCounter-1);
        statement.executeUpdate();
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
