package restproj.entites;

import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.core.Link;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
public class Employee {
    
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private Department department;
    
    @XmlJavaTypeAdapter(Link.JaxbAdapter.class)
    private List<Link> links = new ArrayList<>();

    public Employee (int id,String firstName, String lastName,int age,Department department) {
        this.id= id;
        this.firstName= firstName;
        this.lastName= lastName;
        this.age= age;
        this.department=department;
    }

    public Employee(){

    }

    public List<Link> getLinks(){
        return links;
    }
    
    public void setLinks(List<Link> links){
        this.links=links;
    }
    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName=firstName;
    }

    public void setLastName(String lastName){
        this.lastName=lastName;
    }

    public String getLastName(){
        return lastName;
    }
    public void setAge(int age){
        this.age=age;
    }
    public int getAge(){
        return age;
    }
    public void setId(int id){
        this.id=id;
    }
    public int getId(){
        return id;
    }

    public void setDepartment(Department department){
        this.department=department;
    }

    public Department getDepartment(){
        return department;
    }

    @Override
    public String toString(){
         return this.id + " " + this.firstName + " " + this.lastName + " " + this.age + " \n";
    }

}
