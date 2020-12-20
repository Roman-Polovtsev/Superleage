package com.company.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileHandler<T> {
    private final Logger logger;
    private final Serializer serializer = new Serializer();
    private final Path pathToFile;
    private final Path pathToDirectory;

    public FileHandler() {
        this(LoggerFactory.getLogger(FileHandler.class), null, null);
    }

    public FileHandler(Path pathToFile, Path pathToDirectory) {
        this(LoggerFactory.getLogger(FileHandler.class), pathToFile, pathToDirectory);
    }

    public FileHandler(Logger logger, Path pathToFile, Path pathToDirectory) {
        this.logger = logger;
        this.pathToFile = pathToFile;
        this.pathToDirectory = pathToDirectory;
    }

    public Serializer getSerializer() {
        return serializer;
    }

    public void save(Object object) {
        try {
            Files.write(pathToFile, serializer.serialize(object));
            logger.info("write to file updated list");
        } catch (IOException a) {
            logger.error("IOException during writing to file {} creation, {}", pathToFile, a);
        }
    }

    @SuppressWarnings({})
    public List<T> fileDeserializer() {
        List<T> castedList = new ArrayList<>();
        Object list = null;
        try {
            list = serializer.deserialize(Files.readAllBytes(pathToFile));
        } catch (NoSuchFileException z) {
            logger.error("File does not exist");
            fileCreating();
        } catch (IOException z) {
            logger.error("IOException fail", z);
        } catch (ClassNotFoundException c) {
            logger.error("ClassNotFound fail ", c);
        }
        List<?> notCasted = (List<?>) list;
//        if(notCasted != null)
//            notCasted.forEach((obj)->castedList.add((T)obj));
//        else
        castedList = (List<T>) notCasted;
        return castedList;
    }

    public void deletingFile(Path directory, Path file) {
        if (!Files.exists(directory)) {
            logger.error("There`s no such directory");
            throw new IllegalArgumentException();
        } else {
            try {
                Files.deleteIfExists(file);
            } catch (IOException f) {
                logger.error("IOex during file deleting", f);
            }
        }
        logger.info("File succesfully deleted");
    }

    public void deletingFile() {
        if (!Files.exists(pathToDirectory)) {
            logger.error("There`s no such directory");
            throw new IllegalArgumentException();
        } else {
            try {
                Files.deleteIfExists(pathToFile);
            } catch (IOException f) {
                logger.error("IOex during file deleting", f);
            }
        }
        logger.info("File succesfully deleted");
    }

    public void fileCreating(Path directory, Path file) {
        Path teamFile;
        if (!Files.exists(directory)) {
            try {
                Files.createDirectory(directory);
                logger.info("created directory");
            } catch (IOException a) {
                logger.error("{}", a);
            }
        }
        if (!Files.exists(file)) {
            logger.trace("here if file doesn`t exist yet");
            try {
                logger.trace("here before file creation");
                teamFile = Files.createFile(file);
                logger.info("created file");
            } catch (IOException e) {
                logger.error("IOException during file {} creation, {}", file, e);
            }
        } else
            logger.info("file already exist");
    }

    public void fileCreating() {
        Path teamFile;
        if (!Files.exists(pathToDirectory)) {
            try {
                Files.createDirectory(pathToDirectory);
                logger.info("created directory");
            } catch (IOException a) {
                logger.error("cannot create directory {}", a);
            }
        }
        if (!Files.exists(pathToFile)) {
            logger.trace("here if file doesn`t exist yet");
            try {
                logger.trace("here before file creation");
                teamFile = Files.createFile(pathToFile);
                logger.info("created file");
            } catch (IOException e) {
                logger.error("IOException during file {} creation, {}", pathToFile, e);
            }
        } else
            logger.info("file already exist");
    }
}
