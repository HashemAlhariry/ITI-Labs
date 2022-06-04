package com.ecommerce.repositories.inheritance3;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="student",catalog = "inheritance1")
@DiscriminatorValue("STUD")

public class Student extends Person {


  

    protected String department;

    @Column(name="department",  nullable=true, length=45)
    public String getDepartment() {
        return this.department;
    }
    
    public void setDepartment( String department) {
        this.department = department;
    }


    public Student(){
        
    }

    public Student(Person person ,String department){
        this.firstName=person.firstName;
        this.lastName=person.lastName;
        this.personType="STUD";
        this.department = department;
    }

}
