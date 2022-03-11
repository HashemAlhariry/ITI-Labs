package gov.iti.jets;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class App 
{   
    public static int [] array;
    public static int counter;
    public static Lock lock;

    static{
        counter=0;
        array = new int [100];
        lock = new ReentrantLock();
    }


    public synchronized static void addArray(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.println("Current Thread" + Thread.currentThread().getId());
            array[counter] = arr[i];
            counter++;
        }
    }


    /** ANOTHER SOLUTION */
    public static void addArrayWithLock(int arr[]) {
        try{
            lock.lock();
            for(int i=0;i<arr.length;i++){
                System.out.println("Current Thread" + Thread.currentThread().getId());
                array[counter] = arr[i];
                counter++;
            }
        }finally{
            lock.unlock();
        }
    }

    public static void main( String[] args ) throws InterruptedException
    {       
            int [] firstArray = {1,2,3,4,5,6,7}; 
            int [] secondArray = {8,9,10,11,12,13,14,15,16}; 
            int [] thirdArray = {17,18,19,20,21,22,23,24,25}; 

            Thread t1 = new Thread(()->addArrayWithLock(firstArray));
            Thread t2 = new Thread(()->addArrayWithLock(secondArray));
            Thread t3 = new Thread(()->addArrayWithLock(thirdArray));


            t2.start();
            t1.start();
            t3.start();

            Thread.sleep(5000);
            for(int i=0;i<array.length;i++){
               System.out.println(array[i]);
            }
    
    }
    
    
}
 


