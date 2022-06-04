package gov.iti.jets.bean.classpathscanning.service.impl;

import gov.iti.jets.bean.classpathscanning.dao.impl.AccountDaoImpl;
import gov.iti.jets.bean.classpathscanning.dao.impl.AccountDaoInjectImpl;

import javax.inject.Inject;
import javax.inject.Provider;


public class AccountServiceInjectImpl {
    private Provider<AccountDaoInjectImpl> accountDao;

    @Inject
    public void setAccountDao(Provider<AccountDaoInjectImpl> accountDao){
        this.accountDao = accountDao;
    }

    public Provider<AccountDaoInjectImpl> getAccountDao() {
        return accountDao;
    }
}
