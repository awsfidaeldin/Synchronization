public class SynchStr implements Runnable
{
	StringBuffer  buffer;
	int counter;
		
	public SynchStr() // Constructor.
	{
		buffer=new StringBuffer();
		counter=1;
	}
	
	public void run()
	{
		synchronized(buffer)
		{
			System.out.print("Starting synchronized block ");
			int tempvariable=counter++;
String message = ("count value is " + tempvariable + “\n”);
				
				try
				{
					Thread.sleep(10);
				}
				catch(InterruptedException ie)
				{
					System.err.println("Interrupted");
				}
			buffer.append(message);
			System.out.println("... ending synchronized block");
		}
	}
	
public static void main(String args[]) 
	{
		// Create a new runnable instance 
SynchStr block=new SynchStr();
// Creating Objects of type Class Thread
		Thread t1=new Thread(block);
		Thread t2=new Thread(block);
		Thread t3=new Thread(block);
		Thread t4=new Thread(block);
		//Call the run method
		t1.start(); t2.start(); t3.start(); t4.start();	
		// Wait for all the threads to finish.
		try
{
			t1.join(); t2.join(); t3.join(); t4.join();
}
catch(InterruptedException ie)
{
	System.err.println(“Interrupted”);
}

		System.out.println(block.buffer);
	}	
}
