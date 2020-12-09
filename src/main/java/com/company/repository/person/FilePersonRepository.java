package com.company.repository.person;

import com.company.domain.Person;
import com.company.domain.Player;
import org.apache.log4j.xml.DOMConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

//todo: implement this + repositories for all domain objects
public class FilePersonRepository implements PersonRepository {

    private static final Logger logger = LoggerFactory.getLogger(FilePersonRepository.class);

    private final String repoFilePath = "C:\\Users\\Роман\\IdeaProjects\\Superleage\\personRepo";
    private final Path personPathDir = Paths.get(repoFilePath);
    private final Path filePersonPath = Paths.get(repoFilePath).resolve("persons.txt");
    private final List<Person> personList = new ArrayList<>();

    public void deleteFile (){
        try{Files.deleteIfExists(filePersonPath);}
        catch (IOException io){
            logger.error("{}","cannot delete file",io);
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
                logger.info("{}","Created directory");
            }
        } catch (IOException e){
            logger.error("{}","cannot create directory",e);
        }
        try {
            if (!Files.exists(filePersonPath)){
                Files.createFile(filePersonPath);
                logger.info("{}","created file");}
        } catch (IOException e){
            logger.error("{}","cannot create file",e);
        }
        try{
            //Files.size(filePersonPath) = (byte)0;
            //if(Files.readAllBytes(filePersonPath) == null)
            personList.add(person);
           if(Files.size(filePersonPath) == 0 ){
               Files.write(filePersonPath,person.serialize(personList));
               logger.info("{}","file was empty");
           }
           else {
              // Files.write(filePersonPath,System.getProperty("line.separator").getBytes(),StandardOpenOption.APPEND);
               Files.write(filePersonPath, person.serialize(personList));
               logger.info("{}","file was not empty, just  added in file");
              // Files.
           }
        }
        catch (IOException e){
            logger.error("{}","cannot write to file", e);
        }
        //throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
        PersonRepository persons = new FilePersonRepository();
        FilePersonRepository file = new FilePersonRepository();
        String log4jConfPath = "C:\\Users\\Роман\\IdeaProjects\\Superleage\\src\\main\\java\\resources\\log4j.xml";
        DOMConfigurator.configure(log4jConfPath);
      // file.deleteFile();
        Person person1 = new Person(2000);
       // persons.save(person);
        Person person = new Person("вася",1995);
        persons.save(person);
        long sizeFile = 0;
        try{
            sizeFile = Files.size(file.getFilePersonPath());
            logger.info("{}",sizeFile);
        }
        catch (IOException e){
            logger.error("{}","cannot find file size",e);
        }
//        while ( sizeFile < 100L)
        persons.save(person1);

//        List<Person> all = persons.findAll();
//
//        logger.info("{}",all);
        //    persons.remove(person);
       // file.deleteFile();
    }

    @Override
    public void remove(Person person) {
        Person removingPerson = new Person();
        try{
            byte[] readedBytes = Files.readAllBytes(filePersonPath);
            Object deserialize = person.deserialize(readedBytes);
            logger.info("{}",person.deserialize(readedBytes)+"readed all data for removing");
            byte[] bytes2 = Files.readAllBytes(filePersonPath);
            logger.info("{}",person.deserialize(bytes2));

//            for(int i =0 ; i<readedBytes.length;i++){
//                if( person.equals(readedBytes[i]) )
//                {
//
//                }
//            }
        }
        catch (IOException e){
            logger.error("{}","ioexc",e);
        }
        catch (ClassNotFoundException classexc){
            logger.error("{}","classnotfound", classexc);
        }
        //throw new UnsupportedOperationException();
    }

    public Person findByName(String name) {
        List<Person> all = findAll();
        Person searchingPerson = new Person(name);
        boolean equals = all.contains(searchingPerson);
        logger.info("{}",equals);
        return all.get(0);
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
        List<Person> people = new ArrayList<>();
        Person persons = new Person();
        byte[] readBytes;
        try{
             readBytes = Files.readAllBytes(filePersonPath);
             //List<String> readlines = Files.readAllLines(filePersonPath,StandardCharsets.UTF_8);
          //  logger.info("{}",readBytes);
            ByteArrayInputStream is = new ByteArrayInputStream(readBytes);
            ObjectInputStream in = new ObjectInputStream(is);
            people = (List<Person>) in.readObject();
            //strings = (List<Person>) strings.(readBytes);
            logger.info("{}" + " after reading",people);
//            Person desPerson = new Person("петя", persons.getYearOfBirth());
//            this.save(desPerson);
//            logger.info("{}",desPerson);
            //logger.info("{}",readlines);
        }
        catch (IOException e){
            logger.error("{}",e);
        }
        catch (ClassNotFoundException clas){
            logger.error("{}","smth wrong with class");
        }


       // logger.info("{}",);
    return people;
       // throw new UnsupportedOperationException();
    }
}
