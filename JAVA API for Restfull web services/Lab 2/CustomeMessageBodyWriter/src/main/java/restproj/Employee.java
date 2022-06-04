package restproj;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {
    
    private int id;
    private String firstName;
    private int salary;
     

    public Employee (int id,String firstName, int salary) {
        this.id= id;
        this.firstName= firstName;
        this.salary= salary;
      
    }

    public Employee(){

    }

    public void setFirstName(String firstName){
        this.firstName=firstName;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setSalary(int salary){
        this.salary=salary;
    }
    public int getSalary(){
        return salary;
    }
    public void setId(int id){
        this.id=id;
    }
    public int getId(){
        return id;
    }

    @Override
    public String toString(){
         return this.id + " " + this.firstName + " " + this.salary + " \n";
    }

}
