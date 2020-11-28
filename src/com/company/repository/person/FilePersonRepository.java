package com.company.repository.person;

import com.company.domain.Person;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;

//todo: implement this + repositories for all domain objects
public class FilePersonRepository implements PersonRepository {

    private final String repoFilePath = "C:\\Users\\Роман\\IdeaProjects\\Superleage\\personRepo";
    @Override
    public void save(Person person) {
        Path personPathDir = Paths.get(repoFilePath);
        Path filePersonPath = Paths.get(repoFilePath+"\\persons.txt");
        try {
            if (!Files.exists(personPathDir))
                Files.createDirectories(personPathDir);
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("cannot create directory");
        }
        try {
            if (!Files.exists(filePersonPath))
                Files.createFile(filePersonPath);
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("cannot create file");
        }
        try{
           if(Files.lines(filePersonPath) == null )
            Files.write(filePersonPath,person.getName().getBytes());
           else {
               Files.write(filePersonPath,System.getProperty("line.separator").getBytes(),StandardOpenOption.APPEND);
               Files.write(filePersonPath, "add line".getBytes(), StandardOpenOption.APPEND);
           }
        }
        catch (IOException e){
            e.printStackTrace();
            System.out.println("cannot write to file");
        }
        //throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
        PersonRepository persons = new FilePersonRepository();
        Person person = new Person();
        persons.save(person);
        Person person1 = new Person();
        persons.save(person);
        persons.save(person1);
    }

    @Override
    public void remove(Person person) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Person findById(long personId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Person> findAll() {
        throw new UnsupportedOperationException();
    }
}
