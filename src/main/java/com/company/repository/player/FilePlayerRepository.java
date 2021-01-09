package com.company.repository.player;

import com.company.domain.Player;
import com.company.repository.FileHandler;
import com.company.repository.FileHandlerSaveException;
import com.company.util.FileReadException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilePlayerRepository implements PlayerRepository {

    private final Logger logger ;//= LoggerFactory.getLogger(FilePlayerRepository.class); //todo: constructor
    // private final String repoFile = "D:\\workspace\\Roman\\Superleage\\FileRepository"; //todo: constructor
    private final Path repoFilePath ;//= Paths.get(repoFile);
    private final Path filePath ;//= repoFilePath.resolve("Players.txt"); //todo: constructor
     private final FileHandler<Player> fileHandler;// = new FileHandler(playerList, filePath, repoFilePath); //todo: constructor

    public FilePlayerRepository() {
        this(LoggerFactory.getLogger(FilePlayerRepository.class) );
    }

    public FilePlayerRepository(Logger logger){
        this(logger, "D:\\workspace\\Roman\\Superleage\\FileRepository", "D:\\workspace\\Roman\\Superleage\\FileRepository\\players.txt");
    }

    public FilePlayerRepository(String pathRepository){
        this(LoggerFactory.getLogger(FilePlayerRepository.class),pathRepository,pathRepository+"\\players.txt");
    }

    public FilePlayerRepository(Logger logger,String pathRepository, String pathFile){
        this.logger = logger;
        this.filePath = Paths.get(pathFile);
        this.repoFilePath = Paths.get(pathRepository);
        this.fileHandler = new FileHandler<Player>(filePath,repoFilePath);
    }

    public FilePlayerRepository(Logger logger,Path pathRepository, Path pathFile){
        this.logger = logger;
        this.filePath = pathFile;
        this.repoFilePath = pathRepository;
        this.fileHandler = new FileHandler<Player>(filePath,repoFilePath);
    }
    @Override
    public void save(Player player) throws FileHandlerSaveException {
        List<Player> playerList;
        playerList = fileHandler.deserializedFile();
        if (playerList == null)
            playerList = new ArrayList<>();
        logger.debug("Players list before adding: \n{}", playerList);
        if (playerList.contains(player)) {
            logger.info("such player already exist, updating it");
        } else {
            playerList.add(player);
            logger.debug("Adding player to List: {}", playerList);
        }
        fileHandler.save(playerList);
        logger.debug(playerList.toString());
    }

    @Override
    public void remove(Player player) throws FileHandlerSaveException{
        List<Player> playerList;
        playerList = fileHandler.deserializedFile();

        if (playerList.contains(player)) {
            playerList.remove(player);
            logger.info("Deleted player from List\nNow players list looks like: {}", playerList);
            if (playerList.isEmpty()) {
                fileHandler.deletingFile();
                logger.info("Deleted file because of its emptiness");
            } else {
                fileHandler.save(playerList);
                logger.info("deleted player and serialize anew");
            }
        } else
            logger.info("Nothing to delete, such player doesn`t exist");
        logger.debug("Deserialized player list after removing: \n {}", fileHandler.deserializedFile());
    }

    @Override
    public Player findById(long personId) {
        List<Player> playerList;
//            try{
//                playerList = (List<Player>) fileHandler.fileDeserializer();
//            } catch (MyException e) {
//                throw new NullPointerException();
//            }
        playerList = (List<Player>) fileHandler.deserializedFile();
        if (playerList.isEmpty())
            throw new NullPointerException("There`s no players");
        logger.debug("Deserialized list of players: \n{}", /*deserializedTeam*/playerList);
        for (Player player : /*deserializedTeam*/playerList)
            if (player.hashCode() == personId) {
                logger.info("player {} has been found in List", player.getName());
                return player;
            }
        logger.info("player with such ID not found");
        throw new NullPointerException();
    }

    @Override
    public List<Player> findAll() {
        List<Player> playerList;
        playerList = (List<Player>) fileHandler.deserializedFile();
        logger.debug("Deserialized List of players: {}", playerList);
        return playerList;
    }
}
