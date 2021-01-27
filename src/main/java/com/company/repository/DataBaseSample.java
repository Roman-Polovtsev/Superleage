package com.company.repository;

import java.sql.*;

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
            System.out.println("error " + e);
        }
        return connection;
    }

    public void createDB(Connection connection, String tableName, String sql) throws SQLException {
        Statement statement = connection.createStatement();
        statement.addBatch("drop table if exists " + tableName + " ");
        statement.addBatch(sql);
        //  String sql = "create table persons (id serial , name VARCHAR(39), yearOfBirth int NOT NULL)";
        statement.executeBatch();
        connection.commit();
        statement.close();
    }

    public void dropTable(Connection connection, String tableName) throws SQLException {
        Statement statement1 = connection.createStatement();
        // Statement statement = connection.prepareStatement();
        statement1.executeUpdate(String.format("drop table if exists %s cascade", tableName));
//        statement.setString(1,tableName);
//        statement.execute();
        statement1.close();
    }

    public int deleteRow(Connection connection, String column, int value) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("delete from persons where id = ?");
        statement.setInt(1, value);
        int i = statement.executeUpdate();
        statement.close();
        return i;
    }

    public void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }

    public ResultSet readAllRows(Connection connection, String tableName) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("select * from persons where id > 0", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        //statement.setInt(1,tableName);
        ResultSet resultSet = statement.executeQuery();
        statement.close();
        return resultSet;
    }

    public int insertRow(Connection connection, String tableName, String name, int year) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("insert into persons (name,yearofbirth) values( ?,? )");
        //  statement.setString(1,tableName);
        statement.setString(1, name);
        statement.setInt(2, year);
        int i = statement.executeUpdate();
        statement.close();
        return i;
    }


}
