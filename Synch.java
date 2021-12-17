/*
 * This program is used to demonstrate using synchronization with threads
 */
import java.util.concurrent.*;

public class Synch {
    //define a class variable called counter
     static int counter = 1;
    
    public static void main(String[] args){
        //use lambda notation for the runnable method 
        Runnable r = () -> {
            System.out.println("ID value: "+getID());
        };
        Thread one = new Thread(r,"one");
        one.start();
        Thread two = new Thread(r,"two");
        two.start(); 
    }
    public static synchronized int getID()
    {
        return counter++;
    }  
}
