package com.company.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileHandler {
    public FileHandler() {
    }

    transient public static Logger logger = LoggerFactory.getLogger(FileHandler.class);

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
}
