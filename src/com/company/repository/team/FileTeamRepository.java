package com.company.repository.team;

import com.company.domain.Team;
import org.apache.log4j.xml.DOMConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.*;

//todo: implement this + repositories for all domain objects
public class FileTeamRepository implements TeamRepository {

    private static final Logger logger = LoggerFactory.getLogger(FileTeamRepository.class);
    private static final String basicPath = "C:\\Users\\Роман\\IdeaProjects\\Superleage\\personRepo";



    @Override
    public void save( Team team ) {
        try{
        Path file1 = Files.createFile(Paths.get("E:\\Polovtsev\\git\\Projects\\newFile.txt"));
        } catch (FileAlreadyExistsException e){
            e.printStackTrace();
            try{Files.write(Paths.get("E:\\Polovtsev\\git\\Projects\\newFile.txt"), team.getName().getBytes());}
            catch (IOException a){
                a.printStackTrace();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
       // throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
        String log4jConfPath = "C:\\Users\\Роман\\IdeaProjects\\Superleage\\src\\resources\\log4j.xml";
        DOMConfigurator.configure(log4jConfPath);
        TeamRepository file = new FileTeamRepository();
        Team team = new Team();
        String newFile;
        Team team1 = new Team("abc");
                newFile = team1.getName()+".txt";
          Path pathNew = Paths.get(basicPath,newFile);
          Path pathNew1 = Paths.get(basicPath,team.getName()+".txt");
        try {
            Files.createFile(pathNew);
            Files.createFile(pathNew1);
        }
        catch (IOException e){
            logger.error("IOexception");
        }
//        for(int i = 0; i<3;i++) {
//            newFile = "file" + i + ".txt";
//            Path path1 = Paths.get(basicPath,newFile);
//            try {
//                Files.createFile(path1);
//            }
//            catch (IOException e){
//                logger.error("IOexception");
//            }
//        }
//        file.save(team);
//        file.save(team);
//        file.remove(team);
//        file.remove(team);
//        file.remove(team);
    }



    @Override
    public void remove(Team team) {
        boolean file = false;
        try{
             file = Files.deleteIfExists(Paths.get("E:\\Polovtsev\\git\\Projects\\newFile.txt"));}
//        catch (NoSuchFileException notFound){
//            logger.info("{}","huevo");
//        }
        catch (IOException er){
            er.printStackTrace();
        }
        finally {
            logger.info("{}",file);
        }
        //throw new UnsupportedOperationException();

    }

    @Override
    public Team findById(long personId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Team> getAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Team findByName (String name){ throw new UnsupportedOperationException(); }


}