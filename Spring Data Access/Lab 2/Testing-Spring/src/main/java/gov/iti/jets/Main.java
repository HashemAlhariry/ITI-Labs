package gov.iti.jets;


import gov.iti.jets.bean.dao.UserDao;
import gov.iti.jets.bean.models.User;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
    
    public static void main(String[] args) {

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        UserDao userDaoImpl1 = (UserDao) context.getBean("userDaoImpl1");
        UserDao userDaoImpl2 = (UserDao) context.getBean("userDaoImpl2");


        /*** users in database ***/
        System.out.println("All users in database are: "+userDaoImpl1.count());
        System.out.println("All ages older than 27 are : "+userDaoImpl1.countByAgeGreaterThan(27));

        /*** save user in database ***/
        User user = new User(50,"new account",50);
        System.out.println("User added to DB: "+ userDaoImpl1.save(user));

        /*** save user in database with autocommit false  ***/
        User user1 = new User(50,"new account",40);
        System.out.println("User added to DB autocommit false: "+ userDaoImpl1.saveWithAnotherWay(user1));

        /*** save user in database with autocommit false  ***/
        User user2 = new User(70,"new account 2",60);
        System.out.println("User added to DB autocommit false: "+ userDaoImpl2.save(user2));

    }

}
