package com.company.repository.team;

import com.company.domain.Team;

import java.io.IOException;
import java.util.List;
import java.nio.file.*;


//todo: implement this + repositories for all domain objects
public class FileTeamRepository implements TeamRepository {


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
        TeamRepository file = new FileTeamRepository();
        Team team = new Team();
        file.save(team);
        file.save(team);
        file.remove(team);
        file.remove(team);
//        file.remove(team);
    }

    @Override
    public void remove(Team team) {
        boolean file = false;
        try{
             file = Files.deleteIfExists(Paths.get("E:\\Polovtsev\\git\\Projects\\newFile.txt"));}
//        catch (NoSuchFileException notFound){
//            System.out.println("huevo");
//        }
        catch (IOException er){
            er.printStackTrace();
        }
        finally {
            System.out.println(file);
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