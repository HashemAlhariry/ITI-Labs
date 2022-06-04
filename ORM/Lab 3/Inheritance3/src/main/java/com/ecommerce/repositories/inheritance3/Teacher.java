package com.ecommerce.repositories.inheritance3;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="person",catalog = "inheritance1")
@DiscriminatorValue("TA")
public class Teacher extends Person {
  

    protected Date hireDate;

    @Temporal(TemporalType.DATE)
    @Column(name="hire_date", nullable=true, length=10)
    public Date getHireDate() {
        return this.hireDate;
    }
    
    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
    public Teacher(){
        
    }
    public Teacher(Person person ,Date hireDate){
        this.firstName=person.firstName;
        this.lastName=person.lastName;
        this.personType="TA";
        this.hireDate = hireDate;
    }
    
}
