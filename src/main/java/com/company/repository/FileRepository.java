package com.company.repository;

import com.company.repository.team.FileTeamRepository;
import com.company.util.FileReadException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileRepository<T extends Serializable> implements Repository<T> {

    transient private final Logger logger;
    transient private final FileHandler<T> fileHandler;
    private final Path filePath;

    public FileRepository() {
        this(LoggerFactory.getLogger(FileTeamRepository.class));
    }

    public FileRepository(Logger logger) {
        this(logger, "C:\\Users\\Роман\\IdeaProjects\\Superleague_new\\repository\\teams.txt");
    }

    public FileRepository(String pathFile) {
        this(LoggerFactory.getLogger(FileTeamRepository.class), pathFile);
    }

    public FileRepository(Logger logger, String pathFile) {
        this.logger = logger;
        this.filePath = Paths.get(pathFile);
        this.fileHandler = new FileHandler<T>(this.filePath);
    }

    public FileRepository(Logger logger, Path pathRepository, Path pathFile, FileHandler<T> fileHandler) {
        this.logger = logger;
        this.filePath = pathFile;
        this.fileHandler = fileHandler;
    }

    //todo implement all repositories as template
    @Override
    public void createRepository() {

    }

    @Override
    public void save(T obj) throws Exception {

    }

    @Override
    public void remove(T obj) throws Exception {

    }

    @Override
    public T findById(long objId) throws FileReadException {
        return null;
    }

    @Override
    public List<T> getAll() throws FileRepositoryException {
        try {
            return fileHandler.deserializedFile();
        } catch (FileReadException e) {
            throw new FileRepositoryException(String.format("An error occured during getting list of teams, file handler: %s\npath to file: %s", this.fileHandler, this.filePath), e);
        }
    }

}
