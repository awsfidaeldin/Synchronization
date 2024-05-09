import java.util.concurrent.Semaphore;

class Share
{
	static int count=0;
}

class Mythread1 extends Thread
{
	Semaphore sem;
	String name;
	public Mythread1(Semaphore sem,String name)
	{
		setName(name);
		this.sem=sem;
		this.name=name;
	}
	
	public void run()
	{
		System.out.println("Starting "+this.name);

		if(this.getName().equals("P"))
		{
			System.out.println(this.name+" Waiting for permission ");
			try 
			{
				sem.acquire();
				System.out.println(this.name+" got Permission ");
				for(int i=1;i<5;i++)
				{
					Share.count++;
					System.out.println(this.name+" : "+Share.count);
					Thread.sleep(100);
				}
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			finally
			{
				System.out.println("Releasing "+this.name);
				sem.release();
			}
			
		}
		else
		{
			System.out.println(this.name+" Waiting for permission ");
			try 
			{
				sem.acquire();
				System.out.println(this.name+" got Permission ");
				for(int i=1;i<5;i++)
				{
					System.out.println(this.name+" : "+Share.count);
					Share.count--;
					Thread.sleep(100);
				}
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			finally
			{
				System.out.println("Releasing "+this.name);
				sem.release();
			}
		}

	}
}

public class SemaphoreClass {

	public static void main(String[] args) throws InterruptedException 
	{
		Semaphore sem=new Semaphore(1);
		Mythread1 produce=new Mythread1(sem,"P");
		Mythread1 consume=new Mythread1(sem,"C");
		
		produce.start();
		consume.start();
		
		produce.join();
		consume.join();
		
		System.out.println("The Value for count is "+Share.count);
	}

}
