package gov.iti.jets.lab;

import java.io.Serializable;

public class Address implements Serializable {
    public String street;
    public String suite;
    public String city;
    public String zipcode;
    public Geo geo;

    public Address(){}

    public Address(String street, String suite, String city) {
        this.street = street;
        this.suite = suite;
        this.city = city;
    }
}
