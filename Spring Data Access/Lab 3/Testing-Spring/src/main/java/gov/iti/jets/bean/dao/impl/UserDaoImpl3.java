package gov.iti.jets.bean.dao.impl;

import gov.iti.jets.bean.dao.UserDao;
import gov.iti.jets.bean.models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;
import java.util.Queue;

public class UserDaoImpl3 implements UserDao {

    EntityManager entityManager;
    public void setEntityManager(EntityManagerFactory entityManagerFactory){
                entityManager= entityManagerFactory.createEntityManager();
    }
    @Override
    public long count() {
        String queryString ="select count(*) from User u";
        Query result =  entityManager.createQuery(queryString);
        return result.getFirstResult() ;
    }

    @Override
    public long countByAgeGreaterThan(int age) {
        return 0;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public User saveWithAnotherWay(User user1) {
        return null;
    }
}
