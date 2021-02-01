package com.company.repository.Hall;

import com.company.repository.DataBaseException;
import com.company.repository.DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.DayOfWeek;

public class SqlDaysRepository {
    DataBase dataBase;

    public SqlDaysRepository() throws DataBaseException {
        dataBase = new DataBase();
        String tableNameQuery = "daysOfWeek";
        dataBase.dropTable(tableNameQuery);
        String createTableQuery = "create table daysOfWeek (day_id serial primary key, name varchar (15))";
        dataBase.createDB(tableNameQuery, createTableQuery);
        addDays();
        SqlDaysGameTimeRelation daysGameTimeRelation = new SqlDaysGameTimeRelation();
        daysGameTimeRelation.initDb();
    }

    private void addDays() throws DataBaseException {
        Connection connection = dataBase.getConnection();
        String sql = "insert into daysOfweek (day_id,name) values(?,?)";
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for (int i = 1; i < 8; i++) {
                preparedStatement.setInt(1, i);
                preparedStatement.setString(2, DayOfWeek.of(i).toString());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            connection.commit();
        } catch (SQLException e) {
            throw new DataBaseException("exception during saving days of week", e);
        }
        dataBase.closeConnection(connection);
    }

}
