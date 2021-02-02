package com.company.util;

import com.company.repository.DataBaseException;
import org.postgresql.ds.PGConnectionPoolDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class PoolConnector implements DBConnector {
    private static final String URL_DEFAULT = "jdbc:postgresql://localhost/superlegue?allowMultiQueries=true";
    private static final String USER_DEFAULT = "postgres";
    private static final String PASSWORD_DEFAULT = "29031996roman";
    private static final Logger logger = LoggerFactory.getLogger(PoolConnector.class);
    private final String url;
    private final String user;
    private final String password;
    private final PGConnectionPoolDataSource pgConnectionPoolDataSource;

    public PoolConnector() {
        this(URL_DEFAULT,USER_DEFAULT,PASSWORD_DEFAULT);
    }

    public PoolConnector(String url, String user, String password) {
        pgConnectionPoolDataSource = new PGConnectionPoolDataSource();
        init(url, user, password);
        this.url = url;
        this.user = user;
        this.password = password;
    }

    private void init(String url, String user, String password) {
        pgConnectionPoolDataSource.setURL(url);
        pgConnectionPoolDataSource.setUser(user);
        pgConnectionPoolDataSource.setPassword(password);
        logger.info("successfully set pool connection " + pgConnectionPoolDataSource.getDescription() );
    }

    @Override
    public Connection getConnection() throws DataBaseException {
        Connection connection;
        try {
            connection = pgConnectionPoolDataSource.getConnection();
            logger.info(pgConnectionPoolDataSource.getOptions());
        } catch (SQLException e) {
            throw new DataBaseException(String.format("An error during getting pool connection to PostgreSQL: %s \nunder user: %s\t with password: %s", url, user, password), e);
        }
        return connection;
    }
}


