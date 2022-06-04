package gov.iti.jets.configurations;


import gov.iti.jets.bean.dao.impl.AccountDaoImpl;
import gov.iti.jets.bean.service.AccountService;
import gov.iti.jets.bean.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;


@Configuration
@Profile("Testing")
public class AppConfig {

    @Autowired
    private ModelsConfig modelsConfig;

    @Bean({"account","accountService"})
    public AccountService accountService(){
        return new AccountServiceImpl(modelsConfig.accountDao());
    }


    @Bean(name = "accountWithDependencyPassed")
    @Scope("prototype")
    public AccountService accountService(AccountDaoImpl accountDao){
        AccountServiceImpl accountService = new AccountServiceImpl(accountDao);
        accountService.start();
        return accountService;
    }

    @Bean(initMethod = "init")
    public AccountDaoImpl accountDao(){
        return new AccountDaoImpl();
    }


}
