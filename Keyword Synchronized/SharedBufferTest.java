public class SharedBufferTest
{
   public static void main( String[] args )
   {
      // create SynchronizedBuffer to store ints
      Buffer sharedLocation = new SynchronizedBuffer();
      
      // create new thread pool with two threads
      Writer writer = new Writer (sharedLocation);
      Reader reader = new Reader (sharedLocation);
		
      System.out.printf( "%-40s%s\t\t%s\n%-40s%s\n\n", "Operation", 
         "Buffer", "Occupied", "---------", "------\t\t--------" );

      writer.start();
      reader.start();
   } // end main
} // end class SharedBufferTest
