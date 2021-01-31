package com.company.repository;

import java.io.Serializable;
import java.sql.Connection;
import java.util.List;

public class DBRepository<T extends Serializable> implements Repository<T> {
    private final DataBase database;

    public DBRepository(DataBase database) {
        this.database = database;
    }

    @Override
    public void createRepository() throws DataBaseException {
        Connection connection = database.getConnection();
        // database.createDB(connection);
        database.closeConnection(connection);
    }

    @Override
    public void save(T obj) throws FileRepositoryException {
        //Connection connection = database.getConnection();
        // database.
        // database.closeConnection(connection);

    }

    @Override
    public void remove(T obj) throws FileRepositoryException {

    }

    @Override
    public T findById(long objId)  {
        return null;
    }

    @Override
    public List<T> getAll() throws SQLRepositoryException {
        return null;
    }
}
