package com.company.domain.PlayerDecorator;

import com.company.domain.IdHolders;

import java.util.Objects;

public class DefinedPerson implements AbstractPerson, IdHolders {
    transient private static final long serialVersionUID = 17L;
    //transient public static long idCounter = 1;
    private final long ID;
    private final String name;
    private final int yearOfBirth;

    public DefinedPerson() {
        this("Ivan", 1995, 0);
    }

    public DefinedPerson(String  name){
        this(name,1900, 0);
    }

    public DefinedPerson(String name, int yearOfBirth,long id) {
        this.ID = id;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
      //  idCounter++;
    }

    @Override
    public long getID() {
        return this.ID;
    }
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getYearOfBirth() {
        return this.yearOfBirth;
    }

    @Override
    public String toString() {
        return "DefinedPerson{" +
                "name='" + name + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefinedPerson that = (DefinedPerson) o;
        return yearOfBirth == that.yearOfBirth &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, yearOfBirth);
    }


}
