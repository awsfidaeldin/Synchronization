
public class A implements Runnable{
	
	ReentrantLockClass rlc;
	public A(ReentrantLockClass rlc)
	{
		this.rlc=rlc;
	}
	@Override
	
	public void run() 
	{
		rlc.print(5);
	}
}
