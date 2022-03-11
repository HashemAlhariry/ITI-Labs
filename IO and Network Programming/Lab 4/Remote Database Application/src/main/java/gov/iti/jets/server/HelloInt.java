package gov.iti.jets.server;

import java.rmi.*;
public interface HelloInt extends Remote{
    int  sum(int a1,int a2 ) throws RemoteException;
    int  minus(int a1,int a2 ) throws RemoteException;
    int  multiply(int a1,int a2 ) throws RemoteException;
    int  divide(int a1,int a2 ) throws RemoteException;
}