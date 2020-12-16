package com.company.repository;

public class MyException extends Exception{
    public MyException(Exception e) {
        System.out.println(e + "Handle ME");
    }
}
