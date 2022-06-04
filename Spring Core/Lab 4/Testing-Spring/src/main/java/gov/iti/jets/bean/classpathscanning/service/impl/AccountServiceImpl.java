package gov.iti.jets.bean.classpathscanning.service.impl;

import gov.iti.jets.bean.classpathscanning.dao.impl.AccountDaoImpl;
import org.springframework.stereotype.Service;

import gov.iti.jets.bean.classpathscanning.dao.AccountDao;
import gov.iti.jets.bean.classpathscanning.service.AccountService;

import javax.annotation.Resource;

@Service
public class AccountServiceImpl  implements AccountService{
    

    private AccountDaoImpl accountDao;

    @Resource
    public void setAccountDao(AccountDaoImpl accountDao){
        this.accountDao = accountDao;
    }

    public AccountDaoImpl getAccountDao() {
        return accountDao;
    }


}
