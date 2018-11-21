package multiThreading;

/**
 * Create a thread by implementing a Runnable interface
 * 
 * https://www.tutorialspoint.com/java/java_multithreading.htm
 * 
 * @author sg.ruifeng.ma
 * @since 2018-Nov-20
 */

public class ThreadRunnableImpl implements Runnable {
	private Thread thread;
	private String threadName;
	
	public ThreadRunnableImpl(String name) {
		this.threadName = name;
	}
	
	@Override
	public void run() {
		System.out.println("Running " + this.threadName);
		try {
			for (int i=4; i>0; i--) {
				System.out.println("Pausing on thread " + this.threadName + ", " + i);
				Thread.sleep(50);
			}
		} catch (InterruptedException e) {
			System.out.println("Thread " + this.threadName + " interrupted");
		}
	}
	
	public void start() {
		System.out.println("Starting thread " + this.threadName + "...");
		if (this.thread == null) {
			this.thread = new Thread(this, this.threadName);
			this.thread.start();
		}
	}
	
	public static void main(String[] args) {
		ThreadRunnableImpl t1 = new ThreadRunnableImpl("Thread-1");
		t1.start();
		ThreadRunnableImpl t2 = new ThreadRunnableImpl("Thread-2");
		t2.start();
		
		System.out.println("All cast away. But this is not the end of all threads.");
	}
}

