package gov.iti.jets.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {

    public static void main(String[] args) {

        new Server();

    }

    public Server() {

        try {

            Registry reg = LocateRegistry.createRegistry(1099);
            HelloImpl obj = new HelloImpl();
            //Registry reg = LocateRegistry.getRegistry();
            reg.rebind("HelloService", obj);
            System.out.print("FROM SERVER");

        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        
    }
}