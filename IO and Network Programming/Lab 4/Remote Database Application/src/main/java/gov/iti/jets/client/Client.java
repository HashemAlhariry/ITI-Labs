package gov.iti.jets.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client{

    String [] args;
    public static void main(String[] args){ 

        new Client(args); 
    
    }

    public Client( String [] args){
        this.args=args;
        try{
            
            Registry reg = LocateRegistry.getRegistry("127.0.0.1");
            EmployeeInt helloRef =(EmployeeInt)
            reg.lookup("HelloService");

            System.out.println("ENTERED CLIENT");
            String[] names = reg.list();
            for (String name : names) 
            System.out.println("In the registry: " + name);

            if(args[1].equals("+")){
            
            }
            if(args[1].equals("-")){
           
                System.out.print( helloRef.minus(Integer.parseInt(args[0]),Integer.parseInt(args[2])));
            }
            if(args[1].equals("*")){
    
                System.out.print( helloRef.multiply(Integer.parseInt(args[0]),Integer.parseInt(args[2])));
            }
            if(args[1].equals("/")){
    
                System.out.print(  helloRef.divide(Integer.parseInt(args[0]),Integer.parseInt(args[2])));
            }
        
    
        }
        catch(Exception ex){ 
             ex.printStackTrace();
        }
    }
}