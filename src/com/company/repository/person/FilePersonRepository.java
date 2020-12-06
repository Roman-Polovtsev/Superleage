package com.company.repository.person;

import com.company.domain.Person;
import org.apache.log4j.xml.DOMConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.*;
import java.util.List;

//todo: implement this + repositories for all domain objects
public class FilePersonRepository implements PersonRepository {

    private static final Logger logger = LoggerFactory.getLogger(FilePersonRepository.class);

    private final String repoFilePath = "C:\\Users\\Роман\\IdeaProjects\\Superleage\\personRepo";
    private final Path personPathDir = Paths.get(repoFilePath);
    private final Path filePersonPath = Paths.get(repoFilePath).resolve("persons.txt");

    public void deleteFile (Path filePath){
        try{Files.deleteIfExists(filePath);}
        catch (IOException io){
            io.printStackTrace();
            logger.error("{}","cannot delete file");
        }
    }

    public Path getFilePersonPath() {
        return filePersonPath;
    }

    @Override
    public void save(Person person) {
        final Path personFilePath = Paths.get(repoFilePath, person.getName() + ".txt");
        try {
            if (!Files.exists(personPathDir)){
                Files.createDirectories(personPathDir);
                logger.info("{}","Created directory");
            }
        } catch (IOException e){
            e.printStackTrace();
            logger.error("{}","cannot create directory");
        }
        try {
            if (!Files.exists(personFilePath))
            {
                Files.createFile(personFilePath);
                logger.info("{}","created file " + person.getName());
            }
        } catch (IOException e){
            e.printStackTrace();
            logger.error("{}","cannot create file "+ person.getName());
        }
        try{
            //Files.size(filePersonPath) = (byte)0;
            //if(Files.readAllBytes(filePersonPath) == null)
           if(Files.size(personFilePath) == 0 ){
               Files.write(personFilePath,person.serialize(person));
               logger.info("{}","file " + person.getName()+" was empty");
           }
           else {
              // Files.write(filePersonPath,System.getProperty("line.separator").getBytes(),StandardOpenOption.APPEND);
               Files.write(personFilePath, person.serialize(person), StandardOpenOption.APPEND);
               logger.info("{}","file was not empty, just  added in file");
              // Files.
           }
        }
        catch (IOException e){
            e.printStackTrace();
            logger.error("{}","cannot write to file" + person.getName());
        }
        //throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
        String log4jConfPath = "C:\\Users\\Роман\\IdeaProjects\\Superleage\\src\\resources\\log4j.xml";
        DOMConfigurator.configure(log4jConfPath);
        PersonRepository persons = new FilePersonRepository();
        FilePersonRepository file = new FilePersonRepository();
      // file.deleteFile();
        Person person1 = new Person(2000);
       // persons.save(person);
        Person person = new Person("вася",1995);
        persons.save(person);
//        long sizeFile = 0;
//        try{
//            sizeFile = Files.size(file.getFilePersonPath());
//        }
//        catch (IOException e){
//            e.printStackTrace();
//            logger.error("{}","cannot find file size");
//        }
//        while ( sizeFile < 100L)
            persons.save(person1);
            persons.findByName(person.getName());
       // persons.findAll();
       // persons.remove(person);
       // file.deleteFile();
    }

    @Override
    public void remove(Person person) {
        Person removingPerson = new Person();
        try{
            byte[] readedBytes = Files.readAllBytes(filePersonPath);
            Object deserialize = person.deserialize(readedBytes);
            logger.info("{}",person.deserialize(readedBytes)+"read all data for removing");
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
            logger.error("{}","ioexc");
            e.printStackTrace();
        }
        catch (ClassNotFoundException classexc){
            logger.error("{}","classnotfound");
            classexc.printStackTrace();
        }
        //throw new UnsupportedOperationException();
    }


    @Override
    public Person findByName(String personName){
         logger.info(personName + "sended name to method");
       try {
           Path path = Files.walkFileTree(personPathDir, new FileSearcher(personName +".txt"));
          // Person person = person.deserialize(Files.readAllBytes(Paths.get(path)));
           logger.error(path.toString());
       } catch (IOException e){
           logger.error("IOex");
       }
       Person newPerson = newPerson.deserialize(Files.readAllBytes(personPathDir.resolve(personName)));

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
            logger.info("{}",readBytes);
            persons = (Person) persons.deserialize(readBytes);
            logger.info("{}",persons);
            Person desPerson = new Person("петя", persons.getYearOfBirth());
            this.save(desPerson);
            logger.info("{}",desPerson);
            //logger.info("{}",readlines);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (ClassNotFoundException clas){
            logger.error("{}","smth wrong with class");
        }


       // logger.info("{}",);
    return strings;
       // throw new UnsupportedOperationException();
    }
}
