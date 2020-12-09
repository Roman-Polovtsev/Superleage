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
    transient private FileHandler fileHandler = new FileHandler();
    transient private Serializer serializer = new Serializer();
    public Path getRepoFilePath() {
        return repoFilePath;
    }

    public Serializer getSerializer() {
        return serializer;
    }

    public FileHandler getFileHandler() {
        return fileHandler;
    }

    private final String repoFile = "C:\\Users\\Роман\\IdeaProjects\\Superleage\\FileRepository";
    private final Path repoFilePath = Paths.get(repoFile);
    private final Path fileTeamsPath = repoFilePath.resolve("Teams.txt");
    private final List<Team> teamList = new ArrayList<>();

    public Path getFileTeamsPath() {
        return fileTeamsPath;
    }

    public List<Team> getTeamList() {
        return teamList;
    }

    @Override
    public void save( Team team ) {
        if(teamList.contains(team)) {
            logger.info("such team already exist");
        }
        else {
            teamList.add(team);
           // fileHandler.deletingFile(repoFilePath,fileTeamsPath);
          //  fileHandler.fileCreating(repoFilePath,fileTeamsPath);
            try {
                Files.write(fileTeamsPath, serializer.serialize(teamList));
                logger.info("write to file serialized Team class");
            } catch (IOException a) {
                logger.error("IOException during writing to file {} creation, {}", fileTeamsPath, a);
            }
        }
    }

    public static void main(String[] args) {
        FileTeamRepository file = new FileTeamRepository();
        Team team = new Team();
        file.save(team);
        file.save(new Team("lalki"));
        file.getAll();
        file.remove(team);
        file.getAll();
        file.remove(new Team("lalki"));
        file.getAll();
    }

    @Override
    public void remove(Team team) {
        try{
            //teamList = (List<Team>)this.deserialize(Files.readAllBytes(fileTeamsPath));
            //logger.info("deserialized file: {}",teamList);
             if (teamList.contains(team)) {
                 teamList.remove(team);
                 logger.info("Deleted team from List");
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
            logger.error("IOexception", er);
        }

    }

    @Override
    public Team findById(long personId) throws NullPointerException {
        if (teamList.isEmpty())
            throw new NullPointerException("There`s no Teams");
        else
            return teamList.get((int)personId);
    }

    @Override
    public List<Team> getAll() {
        List<Team> deserializedTeam = null;
        try{
            deserializedTeam = (List<Team>) serializer.deserialize(Files.readAllBytes(this.fileTeamsPath));
        }
        catch (IOException z){
            logger.error("fail", z);
        }
        catch (ClassNotFoundException c){
            logger.error("fail class", c);
        }
        logger.debug("{}",deserializedTeam);
        return deserializedTeam;
    }

    @Override
    public Team findByName (String name){ throw new UnsupportedOperationException(); }



}