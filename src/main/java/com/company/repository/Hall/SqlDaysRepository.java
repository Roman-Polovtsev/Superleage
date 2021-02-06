package com.company.repository.Hall;

import com.company.repository.DataBase;
import com.company.repository.DataBaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.DayOfWeek;

public class SqlDaysRepository {
    private static volatile SqlDaysRepository instance;
    private final DataBase dataBase;
    private static final String tableNameQuery = "daysOfWeek";
    private static final String createTableQuery = "create table daysOfWeek (day_id serial primary key, name varchar (15))";

    private SqlDaysRepository() throws DataBaseException {
        this(new DataBase());
        //  SqlDaysGameTimeRelation daysGameTimeRelation = new SqlDaysGameTimeRelation();
        // daysGameTimeRelation.initDb();
    }

    private SqlDaysRepository(DataBase dataBase) throws DataBaseException {
        this.dataBase = dataBase;
        init();
    }

    public static synchronized SqlDaysRepository getInstance() throws DataBaseException {
        if (instance == null) {
            synchronized (SqlDaysRepository.class) {
                if (instance == null) {
                    instance = new SqlDaysRepository();
                }
            }
        }
        return instance;
    }

    private void init() throws DataBaseException {
        dataBase.dropTable(tableNameQuery);
        dataBase.createDB(tableNameQuery, createTableQuery);
        addDays();
    }

    private void addDays() throws DataBaseException {
        Connection connection = dataBase.getConnection();
        String sql = "insert into daysOfWeek (day_id,name) values(?,?)";
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
            connection.close();
        } catch (SQLException e) {
            throw new DataBaseException("exception during saving days of week", e);
        }
    }

}
