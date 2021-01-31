package com.company.repository.team;

import com.company.domain.Team;

import java.util.List;


public interface TeamRepository {

    void save(Team team) throws Exception;

    void remove(Team team) throws Exception;

    Team findById(long teamId) throws FileRepositoryException;

    List<Team> getAll() throws TeamRepository.FileRepositoryException;

    class FileRepositoryException extends Exception {
        public FileRepositoryException() {
        }

        public FileRepositoryException(String message, Throwable cause) {
            super(message, cause);
        }
    }


}