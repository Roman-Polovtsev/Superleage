package com.company.repository.team;

import com.company.domain.Player;
import com.company.domain.Team;
import com.company.repository.FileHandler;
import com.company.repository.FileHandlerSaveException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


//todo: implement this + repositories for all domain objects
public class FileTeamRepository implements TeamRepository {
    public final Logger logger;
    transient private final FileHandler<Team> fileHandler;
    private final Path repoFilePath;
    private final Path filePath;

    public FileTeamRepository() {
        this(LoggerFactory.getLogger(FileTeamRepository.class));
    }

    public FileTeamRepository(Logger logger) {
        this(logger, "C:\\Users\\Роман\\IdeaProjects\\Superleague_new\\repository", "C:\\Users\\Роман\\IdeaProjects\\Superleague_new\\repository\\teams.txt");
    }

    public FileTeamRepository(String pathRepository) {
        this(LoggerFactory.getLogger(FileTeamRepository.class), pathRepository, pathRepository + "\\teams.txt");
    }

    public FileTeamRepository(Logger logger, String pathRepository, String pathFile) {
        this.logger = logger;
        this.filePath = Paths.get(pathFile);
        this.repoFilePath = Paths.get(pathRepository);
        this.fileHandler = new FileHandler<Team>(this.filePath, this.repoFilePath);
    }

    public FileTeamRepository(Logger logger, Path pathRepository, Path pathFile) {
        this.logger = logger;
        this.filePath = pathFile;
        this.repoFilePath = pathRepository;
        this.fileHandler = new FileHandler<Team>(filePath, repoFilePath);
    }


    public Path getfilePath() {
        return filePath;
    }

    public FileHandler<Team> getFileHandler() {
        return fileHandler;
    }

    public Path getRepoFilePath() {
        return repoFilePath;
    }

    @Override
    public void createRepository() {
      //  fileHandler.fileCreating(repoFilePath, filePath);
    }

    @Override
    public void save(Team team) throws FileHandlerSaveException {
        List<Team> teamList = fileHandler.deserializedFile();
        if (teamList == null)
            teamList = new ArrayList<>();
        if (teamList.contains(team))
            logger.info("such team already exist, updating it");
        else
            teamList.add(team);
        fileHandler.save(teamList);
    }

    @Override
    public void remove(Team team)throws FileHandlerSaveException {
        List<Team> teamList = fileHandler.deserializedFile();
        if (teamList.contains(team)) {
            teamList.remove(team);
            logger.info("Deleted team from List\nNow team list looks like: {}", teamList);
            if (teamList.isEmpty()) {
                fileHandler.deletingFile();
                logger.info("Deleted file because of its emptiness");
            } else {
                fileHandler.save(teamList);
                logger.info("deleted team and serialize anew");
            }
        } else
            logger.info("Nothing to delete, such Team doesn`t exist");
    }

    @Override
    public Team findById(long teamId) throws NullPointerException {
        List<Team> teamList = fileHandler.deserializedFile();
        if (teamList.isEmpty())
            throw new NullPointerException("There`s no Teams");
        else {
            return teamList.stream().filter((team) -> team.getID() == teamId).
                    findFirst().orElseThrow();
        }
    }

    @Override
    public List<Team> getAll() {
        List<Team> deserializedTeams;
        deserializedTeams = fileHandler.deserializedFile();
        return deserializedTeams;
    }


}