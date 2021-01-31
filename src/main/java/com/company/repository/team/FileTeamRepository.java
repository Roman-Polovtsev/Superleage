package com.company.repository.team;

import com.company.domain.Team;
import com.company.repository.FileHandler;
import com.company.util.FileHandlerSaveException;
import com.company.util.FileReadException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


//todo: implement this + repositories for all domain objects
public class FileTeamRepository implements TeamRepository {
    public final Logger logger;
    transient private final FileHandler<Team> fileHandler;
    private final Path filePath;

    public FileTeamRepository() {
        this(LoggerFactory.getLogger(FileTeamRepository.class));
    }

    public FileTeamRepository(Logger logger) {
        this(logger, "C:\\Users\\Роман\\IdeaProjects\\Superleague_new\\repository\\teams.txt");
    }

    public FileTeamRepository(String filePath) {
        this(LoggerFactory.getLogger(FileTeamRepository.class), filePath);
    }

    public FileTeamRepository(Logger logger, String pathFile) {
        this.logger = logger;
        this.filePath = Paths.get(pathFile);
        this.fileHandler = new FileHandler<Team>(filePath);
    }

    public FileTeamRepository(Logger logger, Path pathFile, FileHandler<Team> fileHandler) {
        this.logger = logger;
        this.filePath = pathFile;
        this.fileHandler = fileHandler;
    }


    @Override
    public void save(Team team) throws FileRepositoryException {
        List<Team> teamList;
        try {
            teamList = fileHandler.deserializedFile();
            if (teamList == null)
                teamList = new ArrayList<>();
            if (teamList.contains(team))
                logger.info("such team already exist, updating it");
            else
                teamList.add(team);
            fileHandler.save(teamList);
        } catch (FileHandlerSaveException | FileReadException e) {
            throw new FileRepositoryException(String.format("An error occured during getting list of teams, file handler: %s\npath to file: %s", this.fileHandler, this.filePath), e);
        }
    }

    @Override
    public void remove(Team team) throws FileRepositoryException {
        try {
            List<Team> teamList = fileHandler.deserializedFile();

            if (teamList.contains(team)) {
                teamList.remove(team);
                logger.info("Deleted team from List\nNow team list looks like: {}", teamList);
                fileHandler.save(teamList);
                logger.info("deleted team and serialize anew");
            } else
                logger.info("Nothing to delete, such Team doesn`t exist");
        } catch (FileHandlerSaveException | FileReadException e) {
            throw new FileRepositoryException(String.format("An error occured during getting list of teams, file handler: %s\npath to file: %s", this.fileHandler, this.filePath), e);
        }
    }

    @Override
    public Team findById(long teamId) throws FileRepositoryException {
        try {
            List<Team> teamList = fileHandler.deserializedFile();
            if (teamList.isEmpty())
                throw new NullPointerException("There`s no Teams");
            else {
                return teamList.stream().filter((team) -> team.getID() == teamId).
                        findFirst().orElseThrow();
            }
        } catch (FileReadException e) {
            throw new FileRepositoryException(String.format("An error occured during getting list of teams, file handler: %s\npath to file: %s", this.fileHandler, this.filePath), e);
        }
    }

    @Override
    public List<Team> getAll() throws FileRepositoryException {
        try {
            return fileHandler.deserializedFile();
        } catch (FileReadException e) {
            throw new FileRepositoryException(String.format("An error occured during getting list of teams, file handler: %s\npath to file: %s", this.fileHandler, this.filePath), e);
        }
    }


}