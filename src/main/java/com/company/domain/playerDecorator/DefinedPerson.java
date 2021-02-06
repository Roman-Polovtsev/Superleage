package com.company.domain.playerDecorator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "persons")
public class DefinedPerson implements Person {
    @Transient
    private static final int DEFAULT_YEAR = 1995;
    @Transient
    transient private static final long serialVersionUID = 17L;
    @Id
    @GeneratedValue
    private long ID;
    @Column(name = "person_name")
    private String name;
    @Column(name = "year_of_birth")
    private int yearOfBirth;

    public DefinedPerson() {}

    public DefinedPerson(String name, int yearOfBirth, long id) {
        this.ID = id;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
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
        DefinedPerson person = (DefinedPerson) o;
        return ID == person.ID &&
                yearOfBirth == person.yearOfBirth &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name, yearOfBirth);
    }
}
