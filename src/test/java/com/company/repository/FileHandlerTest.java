package com.company.repository;

import com.company.domain.Person;
import com.company.domain.Player;
import com.company.util.FileReadException;
import com.company.util.FileSystem;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class FileHandlerTest {


    @Test
    public void save() throws IOException {
        Path pathToFile = Mockito.mock(Path.class);
        FileSystem fileSystem = Mockito.mock(FileSystem.class);
        Serializer serializer = new Serializer();
        FileHandler<Player> fileHandler = new FileHandler<>(pathToFile, fileSystem, serializer);
        Player player = new Player("neo");

        List<Player> entities = Collections.singletonList(player);
        fileHandler.save(entities);
        // when(fileHandler.save(entities)).thenThrow(new IOException());
        byte[] expected = serializer.serialize(entities);

        verify(fileSystem, times(1)).write(pathToFile, expected);

    }

    @Test
    public void deserializedFile() throws IOException,FileReadException {
        Path pathToFile = Mockito.mock(Path.class);
        FileSystem fileSystem = Mockito.mock(FileSystem.class);
        Serializer serializer = new Serializer();

        FileHandler<Player> fileHandler = new FileHandler<>(pathToFile, fileSystem, serializer);
        List<Player> players = Arrays.asList(new Player("neo"), new Player("vasya"));
       // when(fileSystem.readAllBytes(pathToFile)).thenReturn(serializer.serialize(players));
        when(fileSystem.readAllBytes(pathToFile)).thenThrow(new ClassNotFoundException());
        List<Player> actual = fileHandler.deserializedFile();

        assertEquals(players, actual);

    }

    @Test
    public void deletingFileTest() throws IOException {
        Path pathToFile = Mockito.mock(Path.class);
        FileSystem fileSystem = Mockito.mock(FileSystem.class);
        Serializer serializer = new Serializer();
        FileHandler<Player> fileHandler = new FileHandler<>(pathToFile, fileSystem, serializer);
        doThrow(new IOException()).when(fileSystem).delete(pathToFile);

        fileHandler.deletingFile();


        verify(fileSystem, times(1)).delete(pathToFile);
//        System.out.println(System.getProperty("java.io.tmpdir"));
//        System.out.println(System.getProperty("java.io.tmpdir"));

    }

}