package gov.iti.jets.bean.classpathscanning.service.impl;

import gov.iti.jets.bean.classpathscanning.dao.impl.AccountDaoImpl;
import gov.iti.jets.bean.classpathscanning.service.AccountServiceTwo;
import org.springframework.context.annotation.Scope;

import javax.annotation.Resource;


@Scope("prototype")
public class AccountServiceTwoImpl implements AccountServiceTwo {
    private AccountDaoImpl accountDao;

    @Resource
    public void setAccountDao(AccountDaoImpl accountDao){
        this.accountDao = accountDao;
    }

    public AccountDaoImpl getAccountDao() {
        return accountDao;
    }
}
