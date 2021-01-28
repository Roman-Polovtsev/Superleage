package com.company.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseSample {
    private final String url;
    private final String user;
    private final String password;

    public DataBaseSample() {
        this("jdbc:postgresql://localhost/superlegue?allowMultiQueries=true", "postgres", "29031996roman");
    }

    public DataBaseSample(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public Connection getConnection() throws DataBaseException {
        Connection connection;
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection set!" + connection.toString());

        } catch (SQLException e) {
            throw new DataBaseException(String.format("An error during getting connection to PostgreSQL: %s \nunder user: %s\t with password: %s",url,user,password),e);
        }
        return connection;
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
            statement.close();
        } catch (SQLException e) {
            throw new DataBaseException(String.format("An error during creating table with pre-deleting existing table with such name: %s ",tableName),e);
        }
        closeConnection(connection);
    }

    public void dropTable(String tableName) throws DataBaseException {
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(String.format("drop table if exists %s cascade", tableName));
            statement.close();
        } catch (SQLException e){
            throw new DataBaseException(String.format("An error during dropping table %s ",tableName),e);
        }
        closeConnection(connection);
    }


    public void closeConnection(Connection connection) throws DataBaseException {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new DataBaseException(String.format("An error during closing connection: %s ",connection),e);
        }
    }


}
