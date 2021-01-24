package com.company.repository;

import com.company.domain.Team;
import com.company.repository.team.FileTeamRepository;
import com.company.util.FileHandlerSaveException;
import com.company.util.FileReadException;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public interface Repository<T extends Serializable> {
    void createRepository() throws FileHandlerSaveException, SQLException;

    void save(T obj) throws FileRepositoryException;

    void remove(T obj) throws FileRepositoryException;

    T findById ( long objId ) throws FileReadException;

    List<T> getAll() throws FileRepositoryException,SQLRepositoryException;

     class FileRepositoryException extends Exception {
        public FileRepositoryException() {
        }
        public FileRepositoryException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    class SQLRepositoryException extends Exception {
        public SQLRepositoryException() {
        }
        public SQLRepositoryException(String message, Throwable cause) {
            super(message, cause);
        }
    }

}
