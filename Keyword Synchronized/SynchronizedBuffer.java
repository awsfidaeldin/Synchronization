public class SynchronizedBuffer implements Buffer
{
   private int buffer = -1; // shared by writer and reader threads
   private boolean occupied = false; // count of occupied buffers
   
   // place value into buffer
   public synchronized void set( int value )
   {
      // while there are no empty locations, place thread in waiting state
      while ( occupied ) 
      {
         // output thread information and buffer information, then wait
         try 
         {
            System.out.println( "Writer tries to write." );
            displayState( "Buffer full. Writer waits." );
            wait();
         } // end try
         catch ( InterruptedException exception ) 
         {
            exception.printStackTrace();
         } // end catch
      } // end while
        
      buffer = value; // set new buffer value
        
      // indicate writer cannot store another value
      // until reader retrieves current buffer value
      occupied = true;
        
      displayState( "Writer writes " + buffer );
      
      notify(); // tell waiting thread to enter runnable state
   } // end method set; releases lock on SynchronizedBuffer 
    
   // return value from buffer
   public synchronized int get()
   {
      // while no data to read, place thread in waiting state
      while ( !occupied )
      {
         // output thread information and buffer information, then wait
         try 
         {
            System.out.println( "Reader tries to read." );
            displayState( "Buffer empty. Reader waits." );
            wait();
         } // end try
         catch ( InterruptedException exception ) 
         {
            exception.printStackTrace();
         } // end catch
      } // end while

      // indicate that writer can store another value 
      // because reader just retrieved buffer value
      occupied = false;

      int readValue = buffer; // store value in buffer
      displayState( "Reader reads " + readValue );
      
      notify(); // tell waiting thread to enter runnable state
      
      return readValue;
   } // end method get; releases lock on SynchronizedBuffer 
    
   // display current operation and buffer state
   public void displayState( String operation )
   {
      System.out.printf( "%-40s%d\t\t%b\n\n", operation, buffer, occupied );
   } // end method displayState
} // end class SynchronizedBuffer
