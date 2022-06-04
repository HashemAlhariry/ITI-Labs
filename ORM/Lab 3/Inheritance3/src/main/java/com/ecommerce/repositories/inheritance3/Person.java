package com.ecommerce.repositories.inheritance3;
 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

 

 
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="person_type")
public class Person  implements java.io.Serializable {


     protected Integer id;
     protected String firstName;
     protected String lastName;
     protected String personType;

 

    public Person() {
    }

	
    public Person(String firstName, String lastName, String personType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personType = personType;
    }
   
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
        
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="first_name", nullable=false, length=50)
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    
    @Column(name="last_name", nullable=false, length=50)
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
    @Column(name="person_type", nullable=false, length=45)
    public String getPersonType() {
        return this.personType;
    }
    
    public void setPersonType(String personType) {
        this.personType = personType;
    }

    

 


}


