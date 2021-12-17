/* This program was created to demonstrate a potential problem 
 * with using Threads in Java
*/

import java.util.*;
import java.io.*;
import java.net.*;


public class SynchProblem {
    static double a = 10;
    static double b; 
    
    public static void main(String[] args) {
//use lambda notation for the runnable method 
         Runnable r1 = ()->
            {
                if(a == 10)
             try {
                 Thread.sleep(0);
                 b = a/2.0;
                 System.out.println(Thread.currentThread().getName() + ": " + b);
             } catch (InterruptedException e) { }
            };
         Runnable r2 = () -> {
               a = 12;   
            };
        Thread thdA = new Thread(r1, "Thread A");
        Thread thdB = new Thread(r2, "Thread B");
        thdA.start();
        thdB.start();
        
    }
    
}
