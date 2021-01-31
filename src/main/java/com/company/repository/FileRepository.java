package com.company.repository;

import com.company.domain.IdHolders;
import com.company.repository.team.FileTeamRepository;
import com.company.util.FileHandlerSaveException;
import com.company.util.FileReadException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileRepository<T extends Serializable & IdHolders> implements Repository<T> {

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
    public void createRepository() throws FileRepositoryException {
        try {
            fileHandler.save(new ArrayList<>());
        } catch (FileHandlerSaveException e) {
            throw new FileRepositoryException(String.format("An error during creating repository of type %s in file on path: %s", this.getClass(), this.filePath), e);
        }
    }

    @Override
    public void save(T obj) throws FileRepositoryException {
        try {
            List<T> list = fileHandler.deserializedFile();
            list.add(obj);
            fileHandler.save(list);
        } catch (FileHandlerSaveException | FileReadException e) {
            throw new FileRepositoryException(String.format("An error during saving data of type %s in file on path: %s", this.getClass(), this.filePath), e);
        }
    }

    @Override
    public void remove(T obj) throws FileRepositoryException {
        try {
            List<T> list = fileHandler.deserializedFile();
            list.remove(obj);
            fileHandler.save(list);
        } catch (FileHandlerSaveException | FileReadException e) {
            throw new FileRepositoryException(String.format("An error during removing data of type %s in file on path: %s", this.getClass(), this.filePath), e);
        }
    }

    @Override
    public T findById(long objId) throws FileRepositoryException {
        try {
            List<T> list = fileHandler.deserializedFile();
            return list.stream().filter((a) -> (a.getID() == objId)).findAny().orElseThrow();
        } catch (FileReadException e) {
            throw new FileRepositoryException(String.format("An error during searching data of type %s by id = %s in file on path: %s", this.getClass(), objId, this.filePath), e);
        }
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
