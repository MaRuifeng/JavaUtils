package multiThreading;

/**
 * Synchronized threads.
 * 
 * @author sg.ruifeng.ma
 * @since 2018-Nov-21
 *
 */

class Printer {
	public void printCount() {
		try {
			for (int i = 5; i > 0; i--) {
				System.out.println("Counter   ---   " + i);
			}
		} catch (Exception e) {
			System.out.println("Thread  interrupted.");
		}
	}
}

public class SynchronizedThread extends Thread {
	private String threadName;
	private Thread thread;
	private Printer printer;
	
	public SynchronizedThread(String name, Printer printer) {
		this.threadName = name;
		this.printer = printer; 
	}
	
	public void run() {
		synchronized (printer) {
			printer.printCount();
		}
		System.out.println("Thread " + this.threadName + " exiting...");
	}
	
	public void start () {
		System.out.println("Starting " + this.threadName);
		if (this.thread == null) {
			this.thread = new Thread(this, this.threadName);
			this.thread.start();
		}
	}
	
	public static void main(String[] args) {
		Printer printer = new Printer();
		SynchronizedThread t1 = new SynchronizedThread("Thread-1", printer);
		SynchronizedThread t2 = new SynchronizedThread("Thread-2", printer);
		
		t1.start();
		t2.start();
		
		// wait for defined threads to end
		try {
			t1.join();
			t2.join();
		} catch (Exception e) {
			System.out.println("Interrupted");
		}
		
		System.out.println("All cast away. But this is not the end of all threads.");
	}
	
}
