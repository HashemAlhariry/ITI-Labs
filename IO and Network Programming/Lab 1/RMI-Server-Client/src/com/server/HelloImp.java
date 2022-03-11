package com.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloImp extends UnicastRemoteObject implements HelloInt{


    public HelloImp() throws RemoteException {
        super();
        System.out.println("Hello Imp Constructor");
    }

    @Override
    public String sayHello(String name) throws RemoteException {
        return "Hello" + name;
    }

    public String sayAnotherHello(String name){
        System.out.println();
        return null;
    }

    
}
