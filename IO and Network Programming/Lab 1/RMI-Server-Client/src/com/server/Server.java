package com.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {

    public static void main(String[] args) {
        try {

            Registry registry = LocateRegistry.createRegistry(5099);
            registry.rebind("hello",new HelloImp());

        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
