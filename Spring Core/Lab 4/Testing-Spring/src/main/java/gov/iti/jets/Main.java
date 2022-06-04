package gov.iti.jets;


import gov.iti.jets.bean.classpathscanning.service.impl.AccountServiceImpl;
import gov.iti.jets.bean.classpathscanning.service.impl.AccountServiceInjectImpl;
import gov.iti.jets.bean.classpathscanning.service.impl.AccountServiceTwoImpl;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
    
    public static void main(String[] args) {

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        context.registerShutdownHook();

        System.out.println("/***-------------***/");
        /*** class path scanning ***/
        AccountServiceImpl accountService  =(AccountServiceImpl) context.getBean("accountServiceImpl");
        accountService.getAccountDao().GetAllAccounts();
        accountService.getAccountDao().setUserName("Hashem");
        accountService.getAccountDao().setPassword("1234567");
        System.out.println(accountService);
        System.out.println("/***-------------***/");

        // bean is provided singleton
        AccountServiceImpl accountService1  =(AccountServiceImpl) context.getBean("accountServiceImpl");
        System.out.println(accountService1);
        System.out.println("/***-------------***/");


        /*** class path scanning filters including ***/
        AccountServiceTwoImpl accountServiceTwo  =(AccountServiceTwoImpl) context.getBean("accountServiceTwoImpl");
        accountServiceTwo.getAccountDao().GetAllAccounts();
        accountServiceTwo.getAccountDao().setUserName("Hashem Two");
        accountServiceTwo.getAccountDao().setPassword("1234567 Two");
        System.out.println(accountServiceTwo.getAccountDao());
        System.out.println(accountServiceTwo);
        System.out.println("/***-------------***/");

        //changing scope of bean to be prototype
        AccountServiceTwoImpl accountServiceTwo1  =(AccountServiceTwoImpl) context.getBean("accountServiceTwoImpl");
        System.out.println(accountServiceTwo1);
        System.out.println("/***-------------***/");

        /*** class path scanning with injection ***/
        AccountServiceInjectImpl accountServiceInjectImpl  = (AccountServiceInjectImpl) context.getBean("accountServiceInjectImpl");
        accountServiceInjectImpl.getAccountDao().get().GetAllAccounts();
        System.out.println(accountServiceInjectImpl.getAccountDao().get());
        System.out.println(accountServiceInjectImpl);
        System.out.println("/***-------------***/");


        context.close();
    }

}
