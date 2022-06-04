package restproj.entites;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {
    
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private Department department;

    public Employee (int id,String firstName, String lastName,int age,Department department) {
        this.id= id;
        this.firstName= firstName;
        this.lastName= lastName;
        this.age= age;
        this.department=department;
    }




    public Employee(){

    }

    public void setFirstName(String firstName){
        this.firstName=firstName;
    }

    public String getFirstName(){
        return firstName;
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
