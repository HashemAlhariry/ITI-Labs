package gov.iti.jets.server;

import java.rmi.*;
import java.rmi.server.*;


public class HelloImpl extends UnicastRemoteObject implements HelloInt{
    
    public HelloImpl() throws RemoteException{
          super();
    }

@Override
public int sum(int a1, int a2) throws RemoteException {
   
     return  a1+a2 ;
      
}

@Override
public int minus(int a1, int a2) throws RemoteException {
      return  a1-a2 ;
      
}

@Override
public int multiply(int a1, int a2) throws RemoteException {
      return  a1*a2 ;
}

@Override
public int divide(int a1, int a2) throws RemoteException {
      return  a1/a2 ;
}
 

}