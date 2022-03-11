package gov.iti.jets;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class App 
{   
    public void serialize(){
        try(ObjectOutputStream objOStrm = new ObjectOutputStream(new FileOutputStream("serial"))){
            MyClass object1 = new MyClass("Hello",-7, 2.7310);
            System.out.println(object1);
            objOStrm.writeObject(object1);
        }catch(IOException e){
            System.out.println("Exception during serialization: " + e);
        }
    }

    public void deserialize(){
        try(ObjectInputStream objOStrm = new ObjectInputStream(new FileInputStream("serial"))){
            MyClass object2  =  (MyClass) objOStrm.readObject();
            System.out.println(object2);
        }catch(Exception e){
            System.out.println("Exception during serialization: " + e);
        }
    }

    public static void main( String[] args ) throws InterruptedException
    {     
        App myApp = new App();
        myApp.serialize();
        myApp.deserialize();
    
    }
    
}
 


