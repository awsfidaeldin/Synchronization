import java.util.Random;

public class Reader extends Thread 
{ 
   private static Random generator = new Random();
   private Buffer sharedLocation; // reference to shared object

   // constructor
   public Reader( Buffer shared )
   {
      sharedLocation = shared;
   } // end Reader constructor

   // read sharedLocation's value four times and sum the values
   public void run()
   {
      int sum = 0;

      for ( int count = 1; count <= 10; count++ ) 
      {
         // sleep 0 to 3 seconds, read value from buffer and add to sum
         try 
         {
            Thread.sleep( generator.nextInt( 3000 ) );    
            sum += sharedLocation.get();
         } // end try
         // if sleeping thread interrupted, print stack trace
         catch ( InterruptedException exception ) 
         {
            exception.printStackTrace();
         } // end catch
      } // end for

      System.out.printf( "\n%s %d.\n%s\n\n", 
         "Reader read values totaling", sum, "Terminating Reader." );
   } // end method run
} // end class Reader
