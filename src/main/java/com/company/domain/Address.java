package com.company.domain;

import java.io.Serializable;
import java.util.Objects;

public class Address implements Serializable {

    private static final long serialVersionUID = 0L;
    private final String city;
    private final String street;
    private final String buildingNumber;


    public Address() {
        this("Undefined", "Undefined", "Undefined");
    }

    public Address(String city) {
        this(city, "undefined", "undefined");
    }

    public Address(String city, String street, String numberOfBuilding) {
        this.city = city;
        this.street = street;
        this.buildingNumber = numberOfBuilding;
    }

    @Override
    public String toString() {
        return getCity() + " " + getStreet() + " " + getBuildingNumber();
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(city, address.city) &&
                Objects.equals(street, address.street) &&
                Objects.equals(buildingNumber, address.buildingNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, buildingNumber);
    }
}
