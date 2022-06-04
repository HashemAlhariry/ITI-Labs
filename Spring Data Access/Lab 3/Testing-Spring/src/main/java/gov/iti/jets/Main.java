package gov.iti.jets;


import gov.iti.jets.bean.dao.UserDao;
import gov.iti.jets.bean.models.User;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
    
    public static void main(String[] args) {

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");


        UserDao userDaoImpl3 = (UserDao) context.getBean("userDaoImpl3");

        userDaoImpl3.count();
        System.out.println(userDaoImpl3.count());
    }

}
