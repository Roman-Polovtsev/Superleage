package com.company;


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



    public static void main(String[] args) {
        Main object = new Main();
        object.testExceptions();


    }
}

