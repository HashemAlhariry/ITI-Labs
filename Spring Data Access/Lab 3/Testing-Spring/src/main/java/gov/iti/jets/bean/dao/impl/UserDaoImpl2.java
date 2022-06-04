package gov.iti.jets.bean.dao.impl;

import gov.iti.jets.bean.dao.UserDao;
import gov.iti.jets.bean.models.User;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

public class UserDaoImpl2 implements UserDao {
    private HibernateTemplate hibernateTemplate;
    private TransactionTemplate transactionTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    @Override
    public long count() {
        String sql = "select count(*) from User ";
        List result = hibernateTemplate.find(sql);
        return (Long) result.get(0);
    }

    @Override
    public long countByAgeGreaterThan(int age){
        String queryString ="select count(*) from User u where u.age >= :age";
        List result = hibernateTemplate.findByNamedParam(queryString,"age",age);
        return (long) result.get(0);
    }

    @Override
    public User save(User user) {
        transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus status) {
                hibernateTemplate.save(user);
                return status;
            }
        });
        return user;
    }

    @Override
    public User saveWithAnotherWay(User user1) {
      return  null;
    }

}
