
public class B implements Runnable{
	
	ReentrantLockClass rlc;
	
	public B(ReentrantLockClass rlc)
	{
		this.rlc=rlc;
	}
	@Override
	public void run() 
	{
		rlc.print(5);
	}

}
