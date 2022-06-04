package gov.iti.jets.dto;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = {"hobbies", "email", "address","name"})
public class Student {

    private int id;
    private String name;
    private String email;
    private int age;
    private List<Address> address;
    private List<String> hobbies = new ArrayList<>();
    public Student() {

    }

    public Student(int id, String name, String email, int age, List<Address> address, List<String> hobbies) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.address = address;
        this.hobbies = hobbies;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @XmlElement(name = "student_name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "email")
    private String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @XmlTransient
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @XmlElementWrapper(name = "addresses")
    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }
    // @XmlList
    @XmlElementWrapper(name = "hobbies")
    @XmlElement(name = "hobby")
    public List<String> getHobbies() {
        return hobbies;
    }
    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "Student [addresses=" + address + ", age=" + age + ", email=" + email + ", hobbies=" + hobbies + ", id="
                + id + ", name=" + name + "]";
    }

}
