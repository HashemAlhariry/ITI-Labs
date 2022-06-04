package gov.iti.jets.bean.classpathscanning.dao.impl;

import gov.iti.jets.bean.classpathscanning.dao.AccountDaoInject;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class AccountDaoInjectImpl implements AccountDaoInject {
    @Override
    public void GetAllAccounts() {
        System.out.println("Hello From Account dao inject impl");
    }

    @PostConstruct
    public void initMethod(){
        System.out.println("ACCOUNT DAO INJECT IMPL INITIALIZED");
    }

    public AccountDaoInjectImpl() {
        System.out.println("ACCOUNT DAO INJECT IMPL INITIALIZED");
    }
}
