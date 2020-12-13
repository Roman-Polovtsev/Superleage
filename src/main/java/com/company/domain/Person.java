package com.company.domain;


import java.io.*;
import java.time.Year;
import java.util.Objects;

public class Person implements Serializable {
    private static final long serialVersionUID = 2L;
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
        if(yearOfBirth > Year.now().getValue())
            throw new IllegalArgumentException("This year is bigger than current, set less number");
        else {
            this.name = "Unnamed";
            this.yearOfBirth = yearOfBirth;
        }
    }

    public Person(String name, int yearOfBirth) {
        if(yearOfBirth > Year.now().getValue())
            throw new IllegalArgumentException("This year is bigger than current, set less number");
        else {
            this.name = name;
            this.yearOfBirth = yearOfBirth;
        }
    }

    public String getName() {
        return name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public byte[] serialize(Object obj) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(out);
        os.writeObject(obj);
        return out.toByteArray();
    }

    public Object deserialize(byte[] data) throws IOException, ClassNotFoundException {
        ByteArrayInputStream in = new ByteArrayInputStream(data);
        ObjectInputStream is = new ObjectInputStream(in);
        return is.readObject();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return yearOfBirth == person.yearOfBirth &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, yearOfBirth);
    }
}
