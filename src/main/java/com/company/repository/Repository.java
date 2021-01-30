package com.company.repository;

import java.io.Serializable;
import java.util.List;

public interface Repository<T extends Serializable> {
    void createRepository() throws DataBaseException, FileRepositoryException;

    void save(T obj) throws FileRepositoryException;

    void remove(T obj) throws FileRepositoryException;

    T findById(long objId) throws FileRepositoryException;

    List<T> getAll() throws FileRepositoryException, SQLRepositoryException;

    class FileRepositoryException extends Exception {

        public FileRepositoryException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    class SQLRepositoryException extends Exception {

        public SQLRepositoryException(String message, Throwable cause) {
            super(message, cause);
        }
    }

}
