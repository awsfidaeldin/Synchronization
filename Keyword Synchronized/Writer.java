import java.util.Random;

public class Writer extends Thread
{
   private static Random generator = new Random();
   private Buffer sharedLocation; // reference to shared object

   // constructor
   public Writer ( Buffer shared )
   {
      sharedLocation = shared;
   } // end Writer constructor

   // store values from 1 to 10 in sharedLocation
   public void run()
   {
      int sum = 0;
      for ( int count = 1; count <= 10; count++ ) 
      {  
         try // sleep 0 to 3 seconds, then place value in Buffer
         {
            Thread.sleep( generator.nextInt( 3000 ) ); // sleep thread   
            sharedLocation.set( count ); // set value in buffer
            sum += count; // increment sum of values
         } // end try
         


        // if sleeping thread interrupted, print stack trace
         catch ( InterruptedException exception ) 
         {
            exception.printStackTrace();
         } // end catch
      } // end for

      System.out.printf( "\n%s %d.\n%s\n\n", 
         "Writer write values totaling", sum, "Terminating Writer." );
   } // end method run
} // end class Writer
