import java.util.concurrent.*;

class Task implements Runnable
{
	Semaphore semaphore=new Semaphore(2);
	public void run() {
		try
		{
			semaphore.acquire();
			System.out.println("Being run by " + Thread.currentThread().getName());
			for(int i=0;i<5;i++)
				System.out.println("Thread Running ... " + Thread.currentThread().getName());
				Thread.sleep(2000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			semaphore.release();
		}
		
	}
	
}


public class SemaphoreCount {

	public static void main(String[] args) {
		Task task=new Task();
		Thread t1=new Thread(task);
		Thread t2=new Thread(task);
		Thread t3=new Thread(task);
		Thread t4=new Thread(task);
		t1.setName("Thread-1");
		t2.setName("Thread-2");
		t3.setName("Thread-3");
		t4.setName("Thread-4");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}
