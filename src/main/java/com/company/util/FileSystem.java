package com.company.util;

import java.io.IOException;
import java.nio.file.Path;

public interface FileSystem {

    void write(Path path, byte[] message) throws IOException;

    byte[] readAllBytes (Path path) throws IOException;


    class Fake implements FileSystem {
        @Override
        public void write(Path path, byte[] message) {
            //do nothing
        }

        @Override
        public byte[] readAllBytes(Path path) {
            return new byte[0];
        }
    }
}
