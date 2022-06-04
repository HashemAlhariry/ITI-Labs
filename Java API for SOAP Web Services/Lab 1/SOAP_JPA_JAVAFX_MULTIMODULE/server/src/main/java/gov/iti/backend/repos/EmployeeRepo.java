package gov.iti.backend.repos;

import gov.iti.backend.repos.dbconnector.Connector;
import gov.iti.backend.repos.entities.EmployeeEntity;
import jakarta.persistence.EntityManager;
import java.util.List;

public class EmployeeRepo {

    private final EntityManager entityManager = Connector.getInstance().getEntityManager();
    private static final EmployeeRepo INSTANCE = new EmployeeRepo();
    private EmployeeRepo() {

    }

    public static EmployeeRepo getInstance() {
        return INSTANCE;
    }

    public boolean delete(EmployeeEntity entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
        return true;
    }

    public List<EmployeeEntity> findAll() {
        List<EmployeeEntity> resultList =  entityManager.createQuery("FROM "+EmployeeEntity.class.getSimpleName()).getResultList();
        return resultList;
    }

    public EmployeeEntity update(EmployeeEntity entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
        return entity;
    }


    public EmployeeEntity findById(int id) {
        return entityManager.find(EmployeeEntity.class, id);
    }

}
