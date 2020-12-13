package com.company.repository.player;

import com.company.domain.Person;
import com.company.domain.Player;
import com.company.domain.Team;
import com.company.repository.FileHandler;
import com.company.repository.MyException;
import com.company.repository.Serializer;
import com.company.repository.team.FileTeamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilePlayerRepository implements PlayerRepository{
    public static final Logger logger = LoggerFactory.getLogger(FilePlayerRepository.class);
    private final String repoFile = "C:\\Users\\Роман\\IdeaProjects\\Superleage\\FileRepository";
    private final Path repoFilePath = Paths.get(repoFile);
    private final Path filePath = repoFilePath.resolve("Players.txt");
    private  List<Player> playerList = new ArrayList<>();
    transient private final FileHandler fileHandler = new FileHandler(playerList,filePath,repoFilePath);

    @Override
    public void save(Player player) {
//        try{
//            playerList = (List<Player>) fileHandler.fileDeserializer();
//        } catch (MyException e) {
//            fileHandler.fileCreating();
//        }
        playerList = (List<Player>) fileHandler.fileDeserializer();
        if (playerList == null)
            playerList = new ArrayList<>();
        logger.debug("Players list before adding: \n{}",playerList);
        if (playerList.contains(player)) {
            logger.info("such player already exist, updating it");
        }
        else {
            playerList.add(player);
            logger.debug("Adding player to List: {}", playerList);
        }
        fileHandler.save(playerList);
        logger.debug(playerList.toString());
    }

    @Override
    public void remove(Player player) {
        if (playerList.contains(player)) {
            playerList.remove(player);
            logger.info("Deleted player from List\nNow players list looks like: {}", playerList);
            if (playerList.isEmpty()){
                fileHandler.deletingFile();
                logger.info("Deleted file because of its emptiness");
            } else {
                fileHandler.save(playerList);
                logger.info("deleted player and serialize anew");
                }
            }
        else
            logger.info("Nothing to delete, such player doesn`t exist");
        logger.debug("Deserialized player list after removing: \n {}",fileHandler.fileDeserializer());
    }

    @Override
    public Player findById(long personId) {
//            try{
//                playerList = (List<Player>) fileHandler.fileDeserializer();
//            } catch (MyException e) {
//                throw new NullPointerException();
//            }
            playerList = (List<Player>) fileHandler.fileDeserializer();
            if (playerList.isEmpty())
                throw new NullPointerException("There`s no players");
            logger.debug("Deserialized list of players: \n{}", /*deserializedTeam*/playerList);
            for (Player player : /*deserializedTeam*/playerList)
                if (player.hashCode() == personId){
                    logger.info("player {} has been found in List", player.getName());
                    return player;
                }
            logger.info("player with such ID not found");
            throw new NullPointerException();
    }

    @Override
    public List<Player> findAll() {
        playerList = (List<Player>) fileHandler.fileDeserializer();
        logger.debug("Deserialized List of players: {}",playerList);
        return playerList;
    }
}
