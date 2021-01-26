package com.company.repository;

import com.company.domain.IdHolders;
import com.company.util.FileHandlerSaveException;
import com.company.util.FileReadException;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DBRepository<T extends Serializable & IdHolders> implements Repository<T>{
    private  final DataBaseSample database;

    public DBRepository(DataBaseSample database) {
        this.database = database;
    }

    @Override
    public void createRepository() throws SQLException {
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
    public T findById(long objId) throws FileReadException {
        return null;
    }

    @Override
    public List<T> getAll() throws  SQLRepositoryException {
        return null;
    }
}
