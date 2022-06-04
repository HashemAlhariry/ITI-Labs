package gov.iti.jets.lab;

import java.io.Serializable;

public class User implements Serializable {
    public int id;
    public String name;
    public String username;
    public Address address;
    public String phone;
    public String email;
    public String website;
    public Company company;


    public User(){}

    public User(int id, String name, String username, Address address, String phone, String email) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

}
