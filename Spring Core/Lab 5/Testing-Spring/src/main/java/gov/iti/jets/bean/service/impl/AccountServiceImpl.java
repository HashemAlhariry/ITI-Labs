package gov.iti.jets.bean.service.impl;

import  gov.iti.jets.bean.dao.impl.AccountDaoImpl;
import gov.iti.jets.bean.service.AccountService;


public class AccountServiceImpl  implements AccountService {
    

    private AccountDaoImpl accountDao;

    public AccountServiceImpl(AccountDaoImpl accountDao) {
        this.accountDao = accountDao;
    }

    public void setAccountDao(AccountDaoImpl accountDao){
        this.accountDao = accountDao;
    }

    public AccountDaoImpl getAccountDao() {
        return accountDao;
    }


    public void start() {
        System.out.println("Start method from AccountServiceImpl");
    }


    public void shutdown(){
        //System.out.println("Shutdown method from AccountServiceImpl");
    }
    /*** calls first if shutdown exists ***/
    public void close(){
        //System.out.println("Close method from AccountServiceImpl");
    }

}

