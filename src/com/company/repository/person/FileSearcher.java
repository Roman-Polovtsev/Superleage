package com.company.repository.person;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

public class FileSearcher extends SimpleFileVisitor<Path> {
    private final PathMatcher matcher;

    private static final Logger logger = LoggerFactory.getLogger(FileSearcher.class);


    FileSearcher(String fileName){
        matcher = FileSystems.getDefault().getPathMatcher("glob:"+fileName);
    }

    void find (Path file){
        Path name = file.getFileName();
        logger.debug(name.toString());
        if (name != null && matcher.matches(name)) {
            logger.info(file.toString()+" this file is here");
            try{
                (Files.readAllBytes(name));
            }
            catch (IOException e){

            }

        }
        else logger.error("there`s no such file in this directory");
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        //logger.debug(file.subpath(1,2).toString());
//        for (Path files: file){
           find(file);
//        }
        return FileVisitResult.CONTINUE;
    }
}
