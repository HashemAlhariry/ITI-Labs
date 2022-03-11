package com.server;

import java.rmi.*;


public interface HelloInt extends Remote{
    String sayHello(String name) throws RemoteException;
}