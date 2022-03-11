package com.client;

import com.server.HelloInt;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RMI_Client {

    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {

       HelloInt helloInt = (HelloInt) Naming.lookup("rmi://localhost:5099/hello");
       System.out.println(helloInt.sayHello(" HASHEM")) ;
    }

}
