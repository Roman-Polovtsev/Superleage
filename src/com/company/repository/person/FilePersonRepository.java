package com.company.repository.person;

import com.company.domain.Person;
import com.company.domain.Player;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;

//todo: implement this + repositories for all domain objects
public class FilePersonRepository implements PersonRepository {

    private final String repoFilePath = "C:\\Users\\Роман\\IdeaProjects\\Superleage\\personRepo";
    private final Path personPathDir = Paths.get(repoFilePath);
    private final Path filePersonPath = Paths.get(repoFilePath).resolve("persons.txt");

    public void deleteFile (){
        try{Files.deleteIfExists(filePersonPath);}
        catch (IOException io){
            io.printStackTrace();
            System.out.println("cannot delete file");
        }
    }

    public Path getFilePersonPath() {
        return filePersonPath;
    }

    @Override
    public void save(Person person) {
        try {
            if (!Files.exists(personPathDir)){
                Files.createDirectories(personPathDir);
                System.out.println("Created directory");
            }
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("cannot create directory");
        }
        try {
            if (!Files.exists(filePersonPath)){
                Files.createFile(filePersonPath);
                System.out.println("created file");}
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("cannot create file");
        }
        try{
            //Files.size(filePersonPath) = (byte)0;
            //if(Files.readAllBytes(filePersonPath) == null)
           if(Files.size(filePersonPath) == 0 ){
               Files.write(filePersonPath,person.serialize(person));
               System.out.println("file was empty");
           }
           else {
              // Files.write(filePersonPath,System.getProperty("line.separator").getBytes(),StandardOpenOption.APPEND);
               Files.write(filePersonPath, person.serialize(person), StandardOpenOption.APPEND);
               System.out.println("file was not empty, just  added in file");
              // Files.
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
        FilePersonRepository file = new FilePersonRepository();
      // file.deleteFile();
        Person person1 = new Person(2000);
       // persons.save(person);
        Person person = new Person("вася",1995);
        persons.save(person);
        long sizeFile = 0;
        try{
            sizeFile = Files.size(file.getFilePersonPath());
        }
        catch (IOException e){
            e.printStackTrace();
            System.out.println("cannot find file size");
        }
        while ( sizeFile < 100L)
            persons.save(person1);
        persons.findAll();
        persons.remove(person);
       // file.deleteFile();
    }

    @Override
    public void remove(Person person) {
        Person removingPerson = new Person();
        try{
            byte[] readedBytes = Files.readAllBytes(filePersonPath);
            Object deserialize = person.deserialize(readedBytes);
            System.out.println(person.deserialize(readedBytes)+"readed all data for removing");
            byte[] bytes2 = Files.readAllBytes(filePersonPath);
            System.out.println(person.deserialize(bytes2));

//            for(int i =0 ; i<readedBytes.length;i++){
//                if( person.equals(readedBytes[i]) )
//                {
//
//                }
//            }
        }
        catch (IOException e){
            System.out.println("ioexc");
            e.printStackTrace();
        }
        catch (ClassNotFoundException classexc){
            System.out.println("classnotfound");
            classexc.printStackTrace();
        }
        //throw new UnsupportedOperationException();
    }

    @Override
    public Person findById(long personId) {
       throw new UnsupportedOperationException();
    }

    @Override
    public List<Person> findAll() {
        //Path personPathDir = Paths.get(repoFilePath);
      //  Path filePersonPath = Paths.get(repoFilePath).resolve("persons.txt");
        List<Person> strings = null;
        Person persons = new Person();
        byte[] readBytes;
        byte[] readBytes1;
        try{
             readBytes = Files.readAllBytes(filePersonPath);
             //List<String> readlines = Files.readAllLines(filePersonPath,StandardCharsets.UTF_8);
            System.out.println(readBytes);
            persons = (Person) persons.deserialize(readBytes);
            System.out.println(persons);
            Person desPerson = new Person("петя", persons.getYearOfBirth());
            this.save(desPerson);
            System.out.println(desPerson);
            //System.out.println(readlines);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (ClassNotFoundException clas){
            System.out.println("smth wrong with class");
        }


       // System.out.println();
    return strings;
       // throw new UnsupportedOperationException();
    }
}
