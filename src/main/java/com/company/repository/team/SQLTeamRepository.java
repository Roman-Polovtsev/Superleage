package com.company.repository.team;

import com.company.domain.Team;
import com.company.repository.DataBaseException;
import com.company.repository.DataBaseSample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class SQLTeamRepository implements TeamRepository {
    DataBaseSample dataBase;

    public SQLTeamRepository() throws DataBaseException {
        dataBase = new DataBaseSample();
        String tableNameQuery = "teams";
        dataBase.dropTable(tableNameQuery);
        String createTableQuery = "create table teams (id serial primary key, name varchar(20), hall_id int, captain_id int)";
        dataBase.createDB(tableNameQuery, createTableQuery);
    }


    @Override
    public void save(Team team) throws DataBaseException, SQLException {
        Connection connection = dataBase.getConnection();
        String sql = "insert into teams values (?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, (int) team.getID());
        statement.setString(2, team.getName());
        statement.setNull(3, 4);
        statement.setNull(4, 4);
        statement.executeUpdate();
        statement.close();
        dataBase.closeConnection(connection);
    }

    @Override
    public void remove(Team team) {

    }

    @Override
    public Team findById(long teamId) {
        return null;
    }

    @Override
    public List<Team> getAll() {
        return null;
    }
}
