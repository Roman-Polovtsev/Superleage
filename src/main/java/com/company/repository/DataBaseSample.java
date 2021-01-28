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

    public Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection set!" + connection.toString());

        } catch (SQLException e) {
          //  throw new DataBaseException
            System.out.println("error " + e);
        }
        return connection;
    }

    public void createDB(String tableName, String sql) throws SQLException {
        Connection connection = getConnection();
        connection.setAutoCommit(false);
        Statement statement = connection.createStatement();
        statement.addBatch("drop table if exists " + tableName + " ");
        statement.addBatch(sql);
        statement.executeBatch();
        connection.commit();
        statement.close();
        closeConnection(connection);
    }

    public void dropTable(String tableName) throws SQLException {
        Connection connection = getConnection();
        Statement statement1 = connection.createStatement();
        statement1.executeUpdate(String.format("drop table if exists %s cascade", tableName));
        statement1.close();
        closeConnection(connection);
    }


    public void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }


}
