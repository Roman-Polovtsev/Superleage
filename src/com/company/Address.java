package com.company;

public class Address {
    private String city;
    private String street;
    private String buildingNumber;


    public Address() {
        this("Undefined", "Undefined", "Undefined");
    }

    public Address(String city, String street, String numberOfBuilding) {
        this.city = city;
        this.street = street;
        this.buildingNumber = numberOfBuilding;
    }

    public String toString() {
        return getCity() + " " + getStreet() + " " + getBuildingNumber();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }




}
