package com.company.repository;

import com.company.domain.Team;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.List;

public class FileHandler {
    transient private final Serializer serializer = new Serializer();
    transient private List<?> collection;
    transient private final Path pathToFile;
    transient private final Path pathToDirectory;

    public FileHandler(){
        this.collection = null;
        this.pathToFile = null;
        this.pathToDirectory = null;
    };

    public Serializer getSerializer() {
        return serializer;
    }

    public FileHandler(List<?> collection, Path pathToFile, Path pathToDirectory) {
        this.collection = collection;
        this.pathToFile = pathToFile;
        this.pathToDirectory = pathToDirectory;
    }

    transient public static Logger logger = LoggerFactory.getLogger(FileHandler.class);



    public void save(Object object){
            try {
                Files.write(pathToFile, serializer.serialize(object/*collection*/));
                logger.info("write to file updated list");
            } catch (IOException a) {
                logger.error("IOException during writing to file {} creation, {}", pathToFile, a);
            }
    }

    public Object fileDeserializer() /*throws IOException*/ {
        Object list = null;
        try{
            list = serializer.deserialize(Files.readAllBytes(pathToFile));
        }
        catch (NoSuchFileException z){
            logger.error("File does not exist");
            fileCreating();
        }
        catch (IOException z){
            logger.error("IOException fail", z);
            //throw new IOException(z);
        }
        catch (ClassNotFoundException c){
            logger.error("ClassNotFound fail ", c);
        }
        return list;
    }

    public void deletingFile(Path directory, Path file){
        if(!Files.exists(directory)) {
            logger.error("There`s no such directory");
            throw new IllegalArgumentException();
        }
        else {
            try{ Files.deleteIfExists(file);
            }
            catch (IOException f){
                logger.error("IOex during file deleting", f);
            }
        }
        logger.info("File succesfully deleted");
    }

    public void deletingFile(){
        if(!Files.exists(pathToDirectory)) {
            logger.error("There`s no such directory");
            throw new IllegalArgumentException();
        }
        else {
            try{ Files.deleteIfExists(pathToFile);
            }
            catch (IOException f){
                logger.error("IOex during file deleting", f);
            }
        }
        logger.info("File succesfully deleted");
    }

    public void fileCreating(Path directory, Path file){
        Path teamFile;
        if(!Files.exists(directory)){
            try{
                Files.createDirectory(directory);
                logger.info("created directory");
            }
            catch (IOException a){
                logger.error("{}",a);
            }
        }
        if(!Files.exists(file)){
            logger.trace("here if file doesn`t exist yet");
            try{
                logger.trace("here before file creation");
                teamFile = Files.createFile(file);
                logger.info("created file");
            } catch (IOException e){
                logger.error("IOException during file {} creation, {}", file,e);
            }
        }
        else
            logger.info("file already exist");
    }

    public void fileCreating (){
        Path teamFile;
        if(!Files.exists(pathToDirectory)){
            try{
                Files.createDirectory(pathToDirectory);
                logger.info("created directory");
            }
            catch (IOException a){
                logger.error("{}",a);
            }
        }
        if(!Files.exists(pathToFile)){
            logger.trace("here if file doesn`t exist yet");
            try{
                logger.trace("here before file creation");
                teamFile = Files.createFile(pathToFile);
                logger.info("created file");
            } catch (IOException e){
                logger.error("IOException during file {} creation, {}", pathToFile,e);
            }
        }
        else
            logger.info("file already exist");
    }
}
