package com.company.util;

import com.company.repository.DataBaseException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SimpleConnector implements DBConnector {
    private static final String URL_DEFAULT = "jdbc:postgresql://localhost/superlegue?allowMultiQueries=true";
    private static final String USER_DEFAULT = "postgres";
    private static final String PASSWORD_DEFAULT = "29031996roman";
    private final String url;
    private final String user;
    private final String password;

    public SimpleConnector() {
        this(URL_DEFAULT, USER_DEFAULT, PASSWORD_DEFAULT);
    }

    public SimpleConnector(String url, String user, String password) {
        this.url = url;
        this.password = password;
        this.user = user;
    }

    @Override
    public Connection getConnection() throws DataBaseException {
        Connection connection;
        try {
             connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new DataBaseException(String.format("An error during getting connection to PostgreSQL: %s \nunder user: %s\t with password: %s", url, user, password), e);
        }
        return connection;
    }
}
