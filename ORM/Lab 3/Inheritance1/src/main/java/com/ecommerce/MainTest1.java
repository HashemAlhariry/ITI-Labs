package com.ecommerce;

 

import java.util.Date;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import com.ecommerce.repositories.inheritance1.Student;
import com.ecommerce.repositories.inheritance1.Teacher;
 

public class MainTest1 {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceTest");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


         Student student= new Student("Ahmed", "Ashraf", "STUD");
         Teacher teacher= new Teacher("Hashem", "Alhariry", new Date());
        
         Student student1= new Student("HASHEM", "Alhariry", "STUD");
         Teacher teacher1= new Teacher("KHALED", "Alhariry", new Date());

         Student student2= new Student("RAMY", "MOHAMMED", "STUD");
         Teacher teacher2= new Teacher("Hashem", "HASHEM", new Date());

        entityManager.getTransaction().begin();
        
        entityManager.persist(student);
        entityManager.persist(teacher);
        
        entityManager.persist(student1);
        entityManager.persist(teacher1);

        entityManager.persist(student2);
        entityManager.persist(teacher2);
        
        entityManager.getTransaction().commit();

        



        

    }
}
