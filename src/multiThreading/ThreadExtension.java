package multiThreading;

/**
 * Creating a thread by extending a Thread class
 * @author sg.ruifeng.ma
 *
 */

public class ThreadExtension extends Thread {
	private Thread thread;
	private String threadName;
	
	public ThreadExtension(String name) {
		this.threadName = name;
	}
	
	public void run() {
		System.out.println("Running " + this.threadName);
		try {
			for (int i=4; i>0; i--) {
				System.out.println("Pausing thread " + this.threadName + ", " + i);
				Thread.sleep(50);
			}
		} catch (InterruptedException e) {
			System.out.println("Thread " + this.threadName + " interrupted");
		}
		System.out.println("Thread " + this.threadName + " exiting...");
	}
	
	public void start() {
		System.out.println("Starting " + this.threadName);
		if (this.thread == null) {
			this.thread = new Thread(this, this.threadName);
			this.thread.start();
		}
	}
	
	public static void main(String[] args) {
		ThreadExtension t1 = new ThreadExtension("Thread-1");
		t1.start();
		ThreadExtension t2 = new ThreadExtension("Thread-1");
		t2.start();
		
		System.out.println("All cast away. But this is not the end of all threads.");
	}

}
