package com.company.domain;



public class Person {
    private final String name;
    private final int yearOfBirth;

    public Person() {
        this("noname");
    }

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



    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
