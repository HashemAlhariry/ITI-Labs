package com.ecommerce;
 
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import com.ecommerce.repositories.inheritance4.Person;
import com.ecommerce.repositories.inheritance4.Student;
import com.ecommerce.repositories.inheritance4.Teacher;



public class MainTest4 {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceTest");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        
        Person studentData= new Person("Hazoma","Alhariry");
        Student student = new Student("Hashem","Alhariry","JAVA");
        Person teacherData= new Person("KHALED","KHALED");
        Teacher teacher = new Teacher("LOAAY","MOHAMMED",new Date());

   
        
        

        entityManager.getTransaction().begin();

      
        entityManager.persist(student);
        entityManager.persist(studentData);
        entityManager.persist(teacher);
      
        
        
        entityManager.getTransaction().commit();

        



        

    }
}
