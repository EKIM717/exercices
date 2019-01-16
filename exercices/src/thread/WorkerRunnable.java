package thread;

import java.util.concurrent.CountDownLatch;

public class WorkerRunnable implements Runnable {
	private final CountDownLatch doneSignal;
	private final String i;
	public WorkerRunnable(CountDownLatch doneSignal, String i) {
		this.doneSignal = doneSignal;
		this.i = i;
	}
	public void run() {
		doWork(i);
		doneSignal.countDown();
	}

	void doWork(String i) {System.out.println(i);}
}
