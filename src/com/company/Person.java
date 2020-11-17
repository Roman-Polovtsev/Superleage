package com.company;



public class Person {
    private String name;
    private int yearOfBirth;

    public Person (String name) {
        this.name = name;
        this.yearOfBirth = 1900;
    }

    public Person (int yearOfBirth){
        this.name = "Unnamed";
        this.yearOfBirth = yearOfBirth;
    }


    public Person(String name, int yearOfBirth) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }
}
