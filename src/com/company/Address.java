package com.company;

public class Address {
    private final String city;
    private final String street;
    private final String buildingNumber;


    public Address() {
        this("Undefined", "Undefined", "Undefined");
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





}
