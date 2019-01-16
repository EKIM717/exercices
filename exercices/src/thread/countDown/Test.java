package thread.countDown;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import thread.WorkerRunnable;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		Driver d = new Driver();
		d.main();
	}
}

class Driver { // ...
	void main() throws InterruptedException {
		int N = 2;
		CountDownLatch doneSignal = new CountDownLatch(N);
		Executor e = Executors.newFixedThreadPool(N);
		
		char[] c = new char[26];
		int i = 0;
		for (char a = 'a'; a <='z'; a++) {
			 c[i++] = a;
		}
		for (char ch : c) // create and start threads
		  e.execute(new WorkerRunnable(doneSignal, ch+""));
		
		doneSignal.await();           // wait for all to finish
	}
}

