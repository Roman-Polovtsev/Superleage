package com.company.repository;

import com.company.domain.Deprecated.Player;
import com.company.util.FileDeletingException;
import com.company.util.FileHandlerSaveException;
import com.company.util.FileReadException;
import com.company.util.FileSystem;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class FileHandlerTest {
    Path pathToFile;
    FileSystem fileSystem;
    Serializer serializer;
    FileHandler<Player> fileHandler;

    @Before
    public void before() {
        pathToFile = Mockito.mock(Path.class);
        fileSystem = Mockito.mock(FileSystem.class);
        serializer = new Serializer();
        fileHandler = new FileHandler<>(pathToFile, fileSystem, serializer);
    }


    @Test
    public void save() throws FileHandlerSaveException, IOException {
        Player player = new Player("neo");

        List<Player> entities = Collections.singletonList(player);
        fileHandler.save(entities);
        byte[] expected = serializer.serialize(entities);

        verify(fileSystem, times(1)).write(pathToFile, expected);
    }

    @Test
            (expected = FileHandlerSaveException.class)
    public void saveException() throws FileHandlerSaveException, IOException {
        Player player = new Player("neo");

        List<Player> entities = Collections.singletonList(player);
        byte[] expected = serializer.serialize(entities);
        doThrow(new IOException("shit happens")).when(fileSystem).write(pathToFile, expected);

        fileHandler.save(entities);
    }

    @Test
    public void deserializedFile() throws IOException, FileReadException {
        List<Player> players = Arrays.asList(new Player("neo"), new Player("vasya"));
        when(fileSystem.readAllBytes(pathToFile)).thenReturn(serializer.serialize(players));
        List<Player> actual = fileHandler.deserializedFile();

        assertEquals(players, actual);
    }

    @Test
            (expected = FileReadException.class)
    public void deserializedFileThrowsException() throws FileReadException, IOException {

       // List<Player> players = Arrays.asList(new Player("neo"), new Player("vasya"));
        when(fileSystem.readAllBytes(pathToFile)).thenThrow(new IOException());

        fileHandler.deserializedFile();

    }

    @Test
    public void deletingFileTest() throws IOException, FileDeletingException {
        //doThrow(new IOException()).when(fileSystem).delete(pathToFile);
        fileHandler.deletingFile();

        verify(fileSystem, times(1)).delete(pathToFile);

    }

    @Test
            (expected = FileDeletingException.class)
    public void deletingFileTestException() throws FileDeletingException, IOException {
        doThrow(new IOException()).when(fileSystem).delete(pathToFile);

        fileHandler.deletingFile();
        // verify(fileSystem, times(1)).delete(pathToFile);
    }
}