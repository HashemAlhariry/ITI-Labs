package gov.iti.jets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class App 
{   

    public static void main( String[] args ) throws InterruptedException
    {     
        
        
        String[] stringArray = new String[100]; 
        int counter = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   
        System.out.println("Enter lines of text. Max 100");
        System.out.println("Enter 'stop' to quit.");
        String str="";

        do{
            try {

                str = br.readLine();
                stringArray[counter]=str;
                counter++;

            } catch (IOException e) {
                e.printStackTrace();
            }
        }while(!str.equals("stop") && counter<100);

        for(int i=0;i<counter-1;i++) {
            System.out.println(stringArray[i]);
        }
        
    }
    
}
 


