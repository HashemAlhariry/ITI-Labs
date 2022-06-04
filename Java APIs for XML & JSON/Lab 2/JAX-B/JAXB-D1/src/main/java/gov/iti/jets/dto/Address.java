package gov.iti.jets.dto;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Address {

    private String country;
    private String city;
    private String street;

    public Address() {

    }

    public Address(String country, String city, String street) {
        this.country = country;
        this.city = city;
        this.street = street;
    }
    
    @Override
    public String toString() {
        return "Address [city=" + city + ", country=" + country + ", street=" + street + "]";
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
}
