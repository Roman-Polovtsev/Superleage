package com.company.repository.player;

import com.company.domain.PlayerDecorator.Player;
import com.company.repository.FileHandler;
import com.company.repository.Repository;
import com.company.util.FileHandlerSaveException;
import com.company.util.FileReadException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FilePlayerRepository implements PlayerRepository {

    private final Logger logger;
    private final Path filePath;
    private final FileHandler<Player> fileHandler;

    public FilePlayerRepository() {
        this(LoggerFactory.getLogger(FilePlayerRepository.class));
    }

    public FilePlayerRepository(Logger logger) {
        this(logger, "D:\\workspace\\Roman\\Superleage\\FileRepository\\players.txt");
    }

    public FilePlayerRepository(String pathFile) {
        this(LoggerFactory.getLogger(FilePlayerRepository.class), pathFile);
    }

    public FilePlayerRepository(Logger logger, String pathFile) {
        this.logger = logger;
        this.filePath = Paths.get(pathFile);
        this.fileHandler = new FileHandler<>(filePath);
    }

    public FilePlayerRepository(Logger logger, Path pathFile) {
        this.logger = logger;
        this.filePath = pathFile;
        this.fileHandler = new FileHandler<>(filePath);
    }

    @Override
    public void save(Player player) throws Repository.FileRepositoryException {
        List<Player> playerList;
        try {
            playerList = fileHandler.deserializedFile();
            logger.debug("Players list before adding: \n{}", playerList);
            playerList.add(player);
            logger.debug("Adding player to List: {}", playerList);
            fileHandler.save(playerList);
        } catch (FileHandlerSaveException | FileReadException e) {
            throw new Repository.FileRepositoryException(String.format("An error during saving player in file on path: %s", this.filePath), e);
        }
    }

    @Override
    public void remove(Player player) throws Repository.FileRepositoryException {
        List<Player> playerList;
        try {
            playerList = fileHandler.deserializedFile();
            playerList.remove(player);
            logger.info("Deleted player from List\nNow players list looks like: {}", playerList);
            fileHandler.save(playerList);
        } catch (FileHandlerSaveException | FileReadException e) {
            throw new Repository.FileRepositoryException(String.format("An error during deleting player from file on path: %s", this.filePath), e);
        }
    }

    @Override
    public Player findById(long playerID) throws Repository.FileRepositoryException {
        List<Player> playerList;
        try {
            playerList = fileHandler.deserializedFile();
        } catch (FileReadException e) {
            throw new Repository.FileRepositoryException(String.format("An error during searching player by id = %s in file on path: %s", playerID, this.filePath), e);
        }
        logger.debug("Deserialized list of players: \n{}", playerList);
        return playerList.stream().filter((player) -> (player.getID() == playerID)).findFirst().orElseThrow();
    }

    @Override
    public List<Player> findAll() throws Repository.FileRepositoryException {
        try {
            logger.debug("Trying to deserialize List of players");
            return fileHandler.deserializedFile();
        } catch (FileReadException e) {
            throw new Repository.FileRepositoryException(String.format("An error occured during getting list of players, file handler: %s\npath to file: %s", this.fileHandler, this.filePath), e);
        }
    }
}
