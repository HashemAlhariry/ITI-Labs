package gov.iti.jets.bean;

import java.util.List;

public class Employee {

    private String name;
    private int id;

    private List<String> addresses;

    public Employee(String name, int id, List<String> addresses) {
        this.name = name;
        this.id = id;
        this.addresses = addresses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee() {
    }

    public List<String> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<String> addresses) {
        this.addresses = addresses;
    }
}
