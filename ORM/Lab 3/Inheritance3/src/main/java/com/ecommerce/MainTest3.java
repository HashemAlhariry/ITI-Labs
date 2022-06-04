package com.ecommerce;

 

import java.util.Date;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import com.ecommerce.repositories.inheritance3.Person;
import com.ecommerce.repositories.inheritance3.Student;
import com.ecommerce.repositories.inheritance3.Teacher;



public class MainTest3 {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceTest");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


          
        Person studentData= new Person("Hazoma","Alhariry","");
        Student student = new Student(studentData,"JAVA");

        Person teacherData= new Person("Hashem","Alhariry","");
        Teacher teacher = new Teacher(teacherData,new Date());

        Person student2Data= new Person("Ahmed","Ashraf","");
        Student student2 = new Student(studentData,".NET");
        
        

        entityManager.getTransaction().begin();

        
        entityManager.persist(student);
        entityManager.persist(student2);
        entityManager.persist(teacher);
        
        
        entityManager.getTransaction().commit();

        



        

    }
}
