package gov.iti.backend.repos.dbconnector;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Connector {

    private static Connector INSTANCE;
    private final EntityManager entityManager;
    private final EntityManagerFactory entityManagerFactory;

    private Connector() {
        entityManagerFactory = Persistence.createEntityManagerFactory("soapSchema");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public static synchronized Connector getInstance() {
        if(INSTANCE==null){
            INSTANCE=new Connector();
        }
        return INSTANCE;
    }

    public void close() {
        if (entityManager.isOpen()) {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

}

