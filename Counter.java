//any thread calling the increment method will first acquire the lock.
//increment counter, release the lock so that other waiting threads can acquire the lock.
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter 
{
//lock is an interface implemented by class ReentrantLock
private final Lock lock=new ReentrantLock();
private int count=0;
//Thread safe increment
//Call method increment
public void increament()
{
	//lock interface has many API. one of them is called lock()
	//acquire the lock.
	lock.lock();
	try
	{
		//increment counter
		count=count+1;
	}
	catch (Exception e)
	{
		e.printStackTrace();
	}
	//finally used just in case some exceptions happen.
	finally
	{
		if(lock!=null)
			//release the lock
			lock.unlock();
	}
}
public int getCount()
{
	return count;
}
}
