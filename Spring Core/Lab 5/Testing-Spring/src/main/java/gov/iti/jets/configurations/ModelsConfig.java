package gov.iti.jets.configurations;

import gov.iti.jets.bean.dao.impl.AccountDaoImpl;
import org.springframework.context.annotation.*;

@Configuration
@ImportResource("classpath:beans.xml")


public class ModelsConfig {

    public ModelsConfig() {
    }

    @Bean(initMethod = "init")
    public AccountDaoImpl accountDao(){
        return new AccountDaoImpl();
    }

}
