package com.company.domain;


import java.io.*;

public class Person implements Serializable {
    private static final long serialVersionUID = -7313374892150962630L;
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

    public byte[] serialize(Object obj) throws IOException {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(out);
        os.writeObject(obj);
        return out.toByteArray();
    }

    public  Object deserialize(byte[] data) throws IOException, ClassNotFoundException {
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
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
