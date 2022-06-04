package com.ecommerce;

import com.ecommerce.handlers.Connector;
import com.ecommerce.repositories.entites.Account;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainTest {

    public static void main(String[] args) {

        Connector conn= Connector.getInstance();
        EntityManager entityManager = conn.getEntityManager();

        //save account
        Account account = new Account("Hashem", "address", "01145190120", "hahahahahahaha", "1234");
        Account account2 = new Account("Hazem", "address", "0123213123", "hahahahahahaha", "2311");
        Account account3 = new Account("Khaled", "address", "0123123123321", "hahahahahahaha", "3213");
        Account account4 = new Account("Alhariry", "address", "012312312312", "hahahahahahaha", "4421");

        entityManager.getTransaction().begin();
        entityManager.persist(account);
        entityManager.persist(account2);
        entityManager.persist(account3);
        entityManager.persist(account4);
        entityManager.getTransaction().commit();

        
       
 


    }
}
