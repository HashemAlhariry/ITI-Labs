package gov.iti.jets.bean.dao.impl;


import gov.iti.jets.bean.dao.UserDao;
import gov.iti.jets.bean.models.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public class UserDaoImpl1  implements UserDao {

    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
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
    @Transactional
    public User save(User user) {
        hibernateTemplate.saveOrUpdate(user);
        return user;
    }

    @Override
    public User saveWithAnotherWay(User user) {

        hibernateTemplate.execute(new HibernateCallback<Object>() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException {
                session.beginTransaction();
                session.save(user);
                session.flush();
                session.getTransaction().commit();
                return user;
            }
        });

        return user;
    }


}
