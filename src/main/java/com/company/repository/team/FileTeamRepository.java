package com.company.repository.team;

import com.company.domain.Team;
import com.company.repository.FileHandler;
import com.company.repository.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.*;


//todo: implement this + repositories for all domain objects
public class FileTeamRepository implements TeamRepository {

    public static final Logger logger = LoggerFactory.getLogger(FileTeamRepository.class);
    transient private final FileHandler fileHandler = new FileHandler();
    transient private final Serializer serializer = new Serializer();
    private final String repoFile = "C:\\Users\\Роман\\IdeaProjects\\Superleage\\FileRepository";
    private final Path repoFilePath = Paths.get(repoFile);
    private final Path fileTeamsPath = repoFilePath.resolve("Teams.txt");
    private  List<Team> teamList = new ArrayList<>();

    public Path getFileTeamsPath() {
        return fileTeamsPath;
    }
    public FileHandler getFileHandler() {
        return fileHandler;
    }
    public List<Team> getTeamList() {
        return teamList;
    }
    public Path getRepoFilePath() {
        return repoFilePath;
    }
    public Serializer getSerializer() {
        return serializer;
    }

    @Override
    public void createRepository() {
        fileHandler.fileCreating(repoFilePath,fileTeamsPath);
    }

    @Override
    public void save( Team team ) {
       // /*deserializedTeam*/teamList = (List<Team>) serializer.deserialize(Files.readAllBytes(fileTeamsPath));

        if(teamList.contains(team)) {
            logger.info("such team already exist, updating it");
            try {
                Files.write(fileTeamsPath, serializer.serialize(teamList));
                logger.info("write to file updated Team list");
            } catch (IOException a) {
                logger.error("IOException during writing to file {} creation, {}", fileTeamsPath, a);
            }
        }
        else {
            teamList.add(team);
            logger.debug("Adding to List team: {}",teamList);
           // fileHandler.deletingFile(repoFilePath,fileTeamsPath);
          //  fileHandler.fileCreating(repoFilePath,fileTeamsPath);
            try {
                Files.write(fileTeamsPath, serializer.serialize(teamList));
                logger.info("write to file updated Team list");
            } catch (IOException a) {
                logger.error("IOException during writing to file {} creation, {}", fileTeamsPath, a);
            }
        }
    }

    @Override
    public void remove(Team team) {
        try{
            //teamList = (List<Team>)this.deserialize(Files.readAllBytes(fileTeamsPath));
            //logger.info("deserialized file: {}",teamList);
             if (teamList.contains(team)) {
                 teamList.remove(team);
                 logger.info("Deleted team from List\nNow team list looks like: {}", teamList);
                 if(teamList.isEmpty()){
                     Files.delete(fileTeamsPath);
                     logger.info("Deleted file because of its emptiness");
                 } else {
                     Files.write(fileTeamsPath,serializer.serialize(teamList));
                     logger.info("deleted team and serialize anew");
                 }
             }
             else
                 logger.info("Nothing to delete, such Team doesn`t exist");
        }
        catch (IOException er){
            logger.error("IOException", er);
        }

    }

    @Override
    public Team findById(long teamId) throws NullPointerException {
        if (teamList.isEmpty())
            throw new NullPointerException("There`s no Teams");
        else {
           // List<Team> deserializedTeam = null;
            try {
                /*deserializedTeam*/teamList = (List<Team>) serializer.deserialize(Files.readAllBytes(fileTeamsPath));
            } catch (IOException z) {
                logger.error("IO fail ", z);
            } catch (ClassNotFoundException c) {
                logger.error("ClassNotFound fail ", c);
            }
            logger.debug("Deserialized list of teams: \n{}", /*deserializedTeam*/teamList);
            for (Team team : /*deserializedTeam*/teamList)
                if (team.hashCode() == teamId){
                    logger.info("Team {} has been found in List", team.getName());
                    return team;
                }
            logger.info("Team with such ID not found");
            throw new NullPointerException();
            }

        }

    @Override
    public List<Team> getAll() {
      //  List<Team> deserializedTeam = null;
        try{
          //  deserializedTeam = (List<Team>) serializer.deserialize(Files.readAllBytes(this.fileTeamsPath));
            teamList = (List<Team>) serializer.deserialize(Files.readAllBytes(this.fileTeamsPath));
        }
        catch (IOException z){
            logger.error("IOException fail", z);
        }
        catch (ClassNotFoundException c){
            logger.error("ClassNotFound fail ", c);
        }
      //  logger.debug("Deserialized List of teams: {}",deserializedTeam);
        logger.debug("Deserialized List of teams: {}",teamList);

        return teamList;
    }


}