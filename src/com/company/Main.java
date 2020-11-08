package com.company;


import javax.imageio.IIOException;
import java.io.*;
import java.nio.CharBuffer;

public class Main {


    private void testExceptions () throws RuntimeException {
        Exceptions testExcept = new Exceptions();
        System.out.println(testExcept.getString());
        //testExcept.TryNumberFormatException(testExcept.getString());
        int integer1 = testExcept.getInteger1();
        //  testExcept.TryStackOverflow(integer1);
        // testExcept.TryNumberFormatException("");
        // testExcept.tryNullPointerException(19);
        testExcept.tryArrayIndexOutOfBoundsAndIllegalArgument(3, "0x32");
    }

    private File tryFileException (){
         File file = new File ("c:\\Users\\Роман\\new.txt");

        System.out.println("file exist: " + file.exists());
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (FileNotFoundException theresNoFile){
                theresNoFile.printStackTrace();
            }
            catch (IOException ioExcept) {
                ioExcept.printStackTrace();
                System.out.println(file.exists());
                System.out.println(file.getName());
            } finally {
                System.out.println(file.getPath());
            }
        } else {
            //file.
            file.delete();
            System.out.println("and now exist? "+file.exists());
            try {
                file.createNewFile();
                System.out.println(file.exists());
            } catch (IOException meow) {
                meow.printStackTrace();
            }
            FileWriter writeString = null;
           try {
               writeString = new FileWriter(file,true);
               writeString.write("Hello world");
           } catch (IOException ioNew) {
               ioNew.printStackTrace();
           }
              try {
                  writeString.close();
                  System.out.println("filewriter closed");
              } catch (IOException closeExcept){
                  closeExcept.printStackTrace();
                  System.out.println("cannot close filewriter");
              }

              try (FileReader readString = new FileReader(file)){
                char [] chars = new char[15];
                  int re = readString.read(chars,8, 7);
                  System.out.println("readed symbols : ");
                  System.out.println(chars);
              } catch (IOException readIO){
                  readIO.printStackTrace();
              }
           // System.out.println(re);

        }

return file;
    }
    private void tryFileNotFound (File file) {
        File newFile = new File(file,"new_new");//"c:\\Users\\Роман\\new_new.txt");
        try(OutputStream ouWriter = new FileOutputStream(newFile)){
            FileWriter fileWr = new FileWriter(newFile);
        } catch (FileNotFoundException noSuchFile){
            noSuchFile.printStackTrace();
        } catch (IOException io ){
            io.getCause();
            io.printStackTrace();
            System.out.println(io.getCause());
        }
       // BufferedWriter buffWr = new BufferedWriter();
    }




    public static void main(String[] args) {
        Main object = new Main();
       // object.testExceptions();
        //File file = object.tryFileException();
        File directory = new File("c:\\Users\\Роман\\new_directory");
        try {
            directory.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        object.tryFileNotFound(directory);


    }
}

