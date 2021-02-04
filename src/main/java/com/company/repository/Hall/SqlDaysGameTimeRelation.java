package com.company.repository.Hall;

import com.company.repository.DataBase;
import com.company.repository.DataBaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SqlDaysGameTimeRelation {
    private static SqlDaysGameTimeRelation instance;
    private static final String TABLE_NAME = "gameTime_days";
    private static final String DEFAULT_QUERY = "create table if not exists gameTime_days (gameTime_id int , day_id int, CONSTRAINT fk_day_id FOREIGN KEY (day_id) REFERENCES daysOfWeek(day_id), CONSTRAINT fk_gameTime_id FOREIGN KEY (gameTime_id) REFERENCES gameTimes(gameTime_id) on delete cascade )";
    private final DataBase dataBase;
    private final String tableName;
    private final String query;


    public static SqlDaysGameTimeRelation getInstance(final DataBase dataBase) throws DataBaseException {
        if (instance == null)
            instance = new SqlDaysGameTimeRelation(dataBase, TABLE_NAME, DEFAULT_QUERY);
        return instance;
    }

    private SqlDaysGameTimeRelation() throws DataBaseException {
        this(new DataBase(), TABLE_NAME, DEFAULT_QUERY);
    }

    private SqlDaysGameTimeRelation(final DataBase dataBase, final String tableName, final String query) throws DataBaseException {
        this.dataBase = dataBase;
        this.tableName = tableName;
        this.query = query;
        initDb();
    }

    public void initDb() throws DataBaseException {
        dataBase.dropTable(tableName);
        dataBase.createDB(TABLE_NAME, query);
    }

    public void save(long gameTimeId, long dayId) throws DataBaseException {
        Connection connection = dataBase.getConnection();
        String sql = "insert into " + tableName + " (gameTime_id,day_id ) values (?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, (int) gameTimeId);
            statement.setInt(2, (int) dayId);
            statement.execute();
            connection.close();
        } catch (SQLException e) {
            throw new DataBaseException(String.format("Exception during saving gameTimeRelation to DB: gameTime_id: %s, day_id: %s \nwith query %s", gameTimeId, dayId, sql), e);
        }
    }
}
