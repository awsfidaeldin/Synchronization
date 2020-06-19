import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
public class ClientTest {
	public static void main(String[] args) {
		ExecutorService executorservice =null;
		try
		{
			//executorservice will be created with working size of 2 threads.
			executorservice=Executors.newFixedThreadPool(2);
			//created an object of class Counter.
			final Counter counter=new Counter();
			//created two tasks (task1 and task2)
			Runnable task1=new Runnable()
					{
				//we have a run method within each task.
				// we are calling the increment method 1000 times.
						public void run()
						{
							for (int i=1;i<=1000;i++)
							{
								counter.increament();
							}
						}
					};
			Runnable task2=new Runnable()
			{
				//we have a run method within each task.
				// we are calling the increment method 2000 times.
				public void run()
				{
					for (int i=1;i<=2000;i++)
					{
						counter.increament();
					}
				}
			};
			//task 1 and 2 are submitted to executorservice by calling the submit() method
			executorservice.submit(task1);
			executorservice.submit(task2);
			//wait 3 seconds to complete those two tasks.
			executorservice.awaitTermination(3,TimeUnit.SECONDS);
			//two threads are trying to complete this count variable.
			System.out.println(counter.getCount());
		}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				if(executorservice!=null)
					//if not shutdown, then executorservice will keep running.
					executorservice.shutdown();
			}
		
	}
}
