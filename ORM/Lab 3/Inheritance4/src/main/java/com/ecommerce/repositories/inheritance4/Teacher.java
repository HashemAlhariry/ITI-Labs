package com.ecommerce.repositories.inheritance4;
// default package
// Generated Mar 31, 2022, 2:27:18 PM by Hibernate Tools 6.0.0.Beta2


import javax.persistence.Column;
import javax.persistence.Entity;
 
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Teacher generated by hbm2java
 */
@Entity
@Table(name="teacher"
    ,catalog="inheritance1"
)
public class Teacher  extends Person{


 
     private Date hireDate;

    public Teacher() {
    }

    public Teacher(String firstName, String lastName,Date hireDate) {
       this.hireDate = hireDate;
       this.firstName=firstName;
       this.lastName=lastName;
    }
    

    @Temporal(TemporalType.DATE)
    @Column(name="hire_date", nullable=false, length=10)
    public Date getHireDate() {
        return this.hireDate;
    }
    
    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }




}


