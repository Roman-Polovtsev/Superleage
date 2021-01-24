package com.company.repository;

import com.company.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Path;
import java.util.List;

public class FileHandler<T extends Serializable> {
    private final Logger logger;
    private final Serializer serializer;
    private final Path pathToFile;
    private final FileSystem fileSystem;

    public FileHandler() {
        this(LoggerFactory.getLogger(FileHandler.class), null);
    }

    public FileHandler(Path pathToFile) {
        this(LoggerFactory.getLogger(FileHandler.class), pathToFile);
    }

    public FileHandler(Logger logger, Path pathToFile ) {
        this(logger,new Serializer(),pathToFile,new JavaFileSystem());
    }

    public FileHandler(Path pathToFile, FileSystem fileSystem, Serializer serializer) {
        this(LoggerFactory.getLogger(FileHandler.class), serializer, pathToFile, fileSystem);
    }

    public FileHandler(Logger logger, Serializer serializer, Path pathToFile, FileSystem fileSystem) {
        this.logger = logger;
        this.serializer = serializer;
        this.pathToFile = pathToFile;
        this.fileSystem = fileSystem;
    }

    public void save(List<T> objects) throws FileHandlerSaveException {
        try {
            fileSystem.write(pathToFile, serializer.serialize(objects));
            logger.info("write to file updated list");
        } catch (IOException e) {
            throw new FileHandlerSaveException(String.format("FileHandlerSaveException during writing to file creation %s", this.pathToFile), e);
        }
    }

    @SuppressWarnings("unchecked")
    public List<T> deserializedFile() throws FileReadException {
        List<T> list = null;
        try {
            return list = (List<T>) serializer.deserialize(fileSystem.readAllBytes(pathToFile));
        } catch (IOException | ClassNotFoundException e) {
            throw new FileReadException(String.format("List of errors in FIleHandler during deserializing file: %s with file system: %s", this.pathToFile, this.fileSystem), e);// todo : implement this
        }
    }


    public void deletingFile() throws FileDeletingException {
        try {
            fileSystem.delete(pathToFile);
        } catch (IOException e) {
            throw new FileDeletingException(String.format("Exception during deleting file on path: %s, with file system as: %s", this.pathToFile, this.fileSystem), e);
        }
    }

    @Override
    public String toString() {
        return "FileHandler{" +
                "serializer=" + serializer +
                ", pathToFile=" + pathToFile +
                ", fileSystem=" + fileSystem +
                '}';
    }
}
