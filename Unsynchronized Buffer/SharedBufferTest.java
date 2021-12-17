public class SharedBufferTest
{
   public static void main( String[] args )
   {
      // create UnsynchronizedBuffer to store ints
      Buffer sharedLocation = new UnsynchronizedBuffer();
      
      // create new thread pool with two threads
      Writer writer = new Writer (sharedLocation);
      Reader reader = new Reader (sharedLocation);

      System.out.println( "Action\t\t\tValue\t\tWritten\t\t\tRead" );
      System.out.println( "------\t\t\t-----\t\t--------\t\t----\n" );
      
      // start writer and reader giving each of them access
      writer.start();
      reader.start();
   } // end main
} // end class SharedBufferTest
