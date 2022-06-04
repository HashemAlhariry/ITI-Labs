package gov.iti.jets;


import gov.iti.jets.bean.UserDao;
import gov.iti.jets.bean.jdbc.JDBCUserDao;
import gov.iti.jets.bean.jdbc.JDBCUserDao3;
import gov.iti.jets.bean.models.User;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
    
    public static void main(String[] args) {

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        UserDao userDao = (JDBCUserDao) context.getBean("userDAO");

        System.out.println(userDao.count());

        System.out.println(userDao.countByAgeGreaterThan(25));

        System.out.println(userDao.findByCustomerId(1));

        System.out.println(userDao.findByCustomerIdWithRowMapper(2));

        System.out.println(userDao.findAll());

        System.out.println(userDao.findAllWithBeanPropertyRowMapper());

        System.out.println(userDao.getUserByName("hashem"));

        /*** inserting new user ***/
        User user = new User();
        user.setName("Etch");
        user.setAge(24);
        userDao.insert(user);

        /*** updating new user ***/
        User user2 = new User();
        user.setName("Hashem Alhariry");
        user.setAge(30);
        user.setId(1);
        userDao.update(user2);

        /*** creating table ***/
        //userDao.createXTable("employees");

        JDBCUserDao3 jdbcUserDao3= (JDBCUserDao3) context.getBean("userDao3");
        jdbcUserDao3.insert(new User(20,"Hazem",17));


    }

}
