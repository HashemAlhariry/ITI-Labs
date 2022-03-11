package gov.iti.jets.client;

import java.rmi.*;
public interface EmployeeInt extends Remote{

    int  add(int a1,int a2 ) throws RemoteException;
    int  update(int a1,int a2 ) throws RemoteException;
    int  delete(int a1,int a2 ) throws RemoteException;
    int  getAllEmployees(int a1,int a2 ) throws RemoteException;

}