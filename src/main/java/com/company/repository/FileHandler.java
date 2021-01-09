package com.company.repository;

import com.company.util.FileReadException;
import com.company.util.FileSystem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class FileHandler<T extends Serializable> {
    private final Logger logger;
    private final Serializer serializer;
    private final Path pathToFile;
    private final Path pathToDirectory;
    private final FileSystem fileSystem;

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
        this.serializer = new Serializer();
        this.fileSystem = new FileSystem.Fake();
    }

    public FileHandler(Path pathToFile, FileSystem fileSystem, Serializer serializer) {
        this(LoggerFactory.getLogger(FileHandler.class), serializer, pathToFile, null, fileSystem);
    }

    public FileHandler(Logger logger, Serializer serializer, Path pathToFile, Path pathToDirectory, FileSystem fileSystem) {
        this.logger = logger;
        this.serializer = serializer;
        this.pathToFile = pathToFile;
        this.pathToDirectory = pathToDirectory;
        this.fileSystem = fileSystem;
    }

    public void save(List<T> objects) throws FileHandlerSaveException {
        try {
            fileSystem.write(pathToFile, serializer.serialize(objects));
            logger.info("write to file updated list");
        } catch (IOException e) {
            throw new FileHandlerSaveException(String.format("FileHandlerSaveException during writing to file creation, {}", this.pathToFile), e);
            // logger.error("IOException during writing to file {} creation, {}", this.pathToFile, e);
        }
    }

    @SuppressWarnings("unchecked")
    public List<T> deserializedFile() {//throws FileReadException {
        List<T> list = null;
        try {
            return list = (List<T>) serializer.deserialize(fileSystem.readAllBytes(pathToFile));
        } catch (IOException | ClassNotFoundException e) {
            // throw new FileReadException("List of errors in FIleHandler " + this, e);// todo : implement this
            logger.error("List of errors in FIleHandler " + this, e);
        }
        return Collections.emptyList();
    }


    public void deletingFile() { // throws IOException{
        try {
            fileSystem.delete(pathToFile);
        } catch (IOException e) {
            //throw new IOException("IO exception during file deleting" + this, e);
            logger.error("IO exception during file deleting" + this, e);
        }
        logger.info("File succesfully deleted");
    }

    @Override
    public String toString() {
        return "FileHandler{" +
                "serializer=" + serializer +
                ", pathToFile=" + pathToFile +
                ", pathToDirectory=" + pathToDirectory +
                ", fileSystem=" + fileSystem +
                '}';
    }
}
