package gov.iti.jets;

import gov.iti.jets.bean.dao.AccountDao;
import gov.iti.jets.bean.dao.impl.AccountDaoImpl;
import gov.iti.jets.bean.service.AccountService;
import gov.iti.jets.bean.service.impl.AccountServiceImpl;
import gov.iti.jets.configurations.AppConfig;
import gov.iti.jets.configurations.ModelsConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class Main {
    
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.registerShutdownHook();

        //Setting profile to testing

        context.getEnvironment().setActiveProfiles("Testing");

        context.register(AppConfig.class, ModelsConfig.class);
        
        context.refresh();

        System.out.println("----------------------------");

        AccountServiceImpl accountService = (AccountServiceImpl) context.getBean("account");
        AccountServiceImpl accountService1 = (AccountServiceImpl) context.getBean("accountWithDependencyPassed") ;
        accountService.getAccountDao().GetAllAccounts();
        System.out.println(accountService);
        System.out.println(accountService1);
        System.out.println("----------------------------");

        AccountServiceImpl accountService2 = (AccountServiceImpl) context.getBean("accountWithDependencyPassed");
        accountService2.getAccountDao().GetAllAccounts();
        System.out.println("----------------------------");

        /***  Getting bean from xml using annotation configuration  ***/
        AccountDaoImpl accountDao = (AccountDaoImpl) context.getBean("accountdao") ;
        accountDao.GetAllAccounts();
        System.out.println("----------------------------");




        context.close();

    }

}
