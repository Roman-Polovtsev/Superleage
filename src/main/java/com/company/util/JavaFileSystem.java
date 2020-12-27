package com.company.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class JavaFileSystem implements FileSystem {
    @Override
    public void write(Path path, byte[] message) throws IOException{
        Files.write(path,message);
    }

    @Override
    public byte[] readAllBytes(Path path) throws IOException {
        return Files.readAllBytes(path);
    }
}
