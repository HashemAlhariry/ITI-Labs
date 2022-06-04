package com.ecommerce.handlers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Connector {

    private static Connector INSTANCE;
    private EntityManager entityManager;
    private static EntityManagerFactory entityManagerFactory;

    private Connector() {
        entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceTest");
    }

    public static Connector getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Connector();
        }
        return INSTANCE;
    }

    public void close() {
        if (entityManager.isOpen()) {
            entityManagerFactory.close();
        }
    }

    public EntityManagerFactory gEntityManagerFactory(){
        return entityManagerFactory;
    }
    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}
