package gov.iti.jets.lab;

import java.io.Serializable;

public class User implements Serializable {

    public int id;
    public String name;
    public String userName;
    public Address address;
    public String phone;
    public String email;

    public User(int id, String name, String userName, Address address, String phone, String email) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public User(int id, String name, String userName, String phone, String email) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.phone = phone;
        this.email = email;
    }
}
