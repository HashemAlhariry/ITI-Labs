package com.ecommerce;

 

import java.util.Date;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ecommerce.repositories.inheritance2.Person;
import com.ecommerce.repositories.inheritance2.Student;
import com.ecommerce.repositories.inheritance2.Teacher;


//import com.ecommerce.repositories.inheritance2.Person;
//import com.ecommerce.repositories.inheritance2.Student;
//import com.ecommerce.repositories.inheritance2.Teacher;


public class MainTest2 {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceTest");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


      
        Person person1= new Person("Hazoma","Alhariry");
        Student student = new Student("HASHEM","KHALED","JAVA");

        Person person2= new Person("HAZOMA","KHALODA");
        Teacher teacher = new Teacher("AHMED","ASHRAF",new Date());

    


        entityManager.getTransaction().begin();

        
       // entityManager.persist(person1);
        entityManager.persist(student);
      //  entityManager.persist(person2);
        entityManager.persist(teacher);
        
        entityManager.getTransaction().commit();

        



        

    }
}
