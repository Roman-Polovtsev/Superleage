package com.company.repository;

import com.company.util.DBConnector;
import com.company.util.PoolConnector;
import com.company.util.SimpleConnector;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
    private final DBConnector dbConnector;

    public DataBase() {
        this(new PoolConnector());
    }

    public DataBase(DBConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

    public DataBase(String url, String user, String password) {
        this.dbConnector = new SimpleConnector(url, user, password);
    }

    public Connection getConnection() throws DataBaseException {
        return dbConnector.getConnection();
    }

    public void createDB(String tableName, String sql) throws DataBaseException {
        Connection connection = getConnection();
        try {
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            statement.addBatch("drop table if exists " + tableName + " ");
            statement.addBatch(sql);
            statement.executeBatch();
            connection.commit();
            connection.close();
        } catch (SQLException e) {
            throw new DataBaseException(String.format("An error during creating table with pre-deleting existing table with such name: %s ", tableName), e);
        }
    }

    public void dropTable(String tableName) throws DataBaseException {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(String.format("drop table if exists %s cascade", tableName));
            connection.close();
        } catch (SQLException e) {
            throw new DataBaseException(String.format("An error during dropping table %s ", tableName), e);
        }
    }


}
